package com.jbirdvegas.nest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jbirdvegas.nest.deserializers.NestStatusDeserializer;
import com.jbirdvegas.nest.deserializers.WeatherDeserializer;
import com.jbirdvegas.nest.exceptions.NestSetupIncompleteException;
import com.jbirdvegas.nest.models.ChangeAutoAwayObject;
import com.jbirdvegas.nest.models.ChangeTempObject;
import com.jbirdvegas.nest.models.LogInPayload;
import com.jbirdvegas.nest.models.NestStatus;
import com.jbirdvegas.nest.models.Session;
import com.jbirdvegas.nest.models.TempPayload;
import com.jbirdvegas.nest.models.Urls;
import com.jbirdvegas.nest.models.items.NestValue;
import com.jbirdvegas.nest.models.valueobjects.NestTempValues;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.models.valueobjects.StructureValueObject;
import com.jbirdvegas.nest.models.valueobjects.TouchedByObject;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;
import com.jbirdvegas.nest.models.weather.WeatherByZipcode;
import com.jbirdvegas.nest.payloads.NestAutoAwayValues;
import com.jbirdvegas.nest.utils.TempConversion;
import com.jbirdvegas.nest.utils.UrlHelper;
import com.jbirdvegas.nest.utils.ValueObjectFinder;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.ContentEncodingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jbird: 3/17/14
 */
public class NestHelper implements Serializable {
    private Session mSession;
    private NestStatus mNestStats;
    private WeatherByZipcode mWeatherByZipcode;
    private boolean mDebug;
    private String mPassword;
    private String mEmail;

    public Session getSession() {
        return mSession;
    }

    public NestStatus getNestStats() {
        return mNestStats;
    }

    public WeatherByZipcode getWeatherByZipcode() {
        return mWeatherByZipcode;
    }

    private class Constants {
        public static final String NEST_SESSION_URL = "https://home.nest.com/session";
        public static final String WEATHER_URL = "http://weather.nest.com/weather/v1";
        public static final String USER_AGENT = "Nest/4.0.3.23.403023 (Android; Obsidian) os=4.4.2 size=2 density=480 platform=Nexus 5";
        private static final String USER_AGENT_KEY = "User-Agent";
        private static final String HOST_KEY = "Host";
        private static final String HOST_HOME = "home.nest.com";
        private static final String ACCEPT_ENCODING = "Accept-Encoding";
        private static final String CONNECTION_KEY = "Connection";
        private static final String AUTHORIZATION_KEY = "Authorization";
        private static final String SEND_AUTH_KEY = "X-nl-send-www-auth";
        private static final String PROTOCOL_VERSION = "X-nl-protocol-version";
        private static final String CONTENT_TYPE_KEY = "Content-Type";
        private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
        private static final String CONTENT_LENGTH = "Content-Length";
        private static final String SESSION_ID_KEY = "X-nl-session-id";
        private static final String USER_ID_KEY = "X-nl-user-id";
        public static final String ENCODING = "gzip";
        public static final String CONNECTION = "Keep-Alive";
    }

    public NestHelper(String email, String password) throws NestSetupIncompleteException {
        mEmail = email;
        mPassword = password;

        // initialization path
        try {
            log("Signing into Nest HQ...");
            mSession = logIn();
            log("Gathering information about your Nest devices...");
            mNestStats = getNestStats(mSession);
            Urls urls = mSession.getUrls();
            List<NestValue> structure = new ValueObjectFinder().findNestValueObjects(mNestStats, StructureValueObject.class);
            log("Checking with Nest for your local weather forecast...");
            mWeatherByZipcode = getLocalWeather(urls, (StructureValueObject) structure.get(0));
            double tempFahrenheit = mWeatherByZipcode.getCurrentForcast().getTempFahrenheit();
            List<NestValue> devices = new ValueObjectFinder().findNestValueObjects(mNestStats, SharedValueObject.class);
            String[] temps = new String [devices.size()];
            for (int i = 0; devices.size() > i; i++) {
                SharedValueObject sharedValueObject = (SharedValueObject) devices.get(i);
                double currentTemp = sharedValueObject.getCurrentTemp();
                temps[i] = String.format("%s : %d", sharedValueObject.getName(), TempConversion.getFahrenheit(currentTemp));
            }
            System.out.println("Currently nest reads: " + Arrays.toString(temps));
            System.out.println(String.format("The current temp in Fahrenheit for %s is %f", mWeatherByZipcode.getLocation().getFullName(), tempFahrenheit));
        } catch (IOException e) {
            throw new NestSetupIncompleteException(e);
        }
    }

    private void log(String notice) {
        System.out.println(notice);
    }

    public Session logIn() throws IOException {
        HttpPost post = new HttpPost(Constants.NEST_SESSION_URL);
        LogInPayload payload = new LogInPayload(mEmail, mPassword);
        String jsonPayload = new Gson().toJson(payload);
        post.addHeader(addContentType());
        post.addHeader(addUserAgent());
        post.addHeader(addAcceptedEncoding());
        post.addHeader(addSendAuth());
        // Content-Length is added by StringEntity
//        post.addHeader(addContentLength(jsonPayload.length()));
        post.addHeader(addHost(Constants.HOST_HOME));
        post.addHeader(addConnection());
        post.setEntity(new StringEntity(jsonPayload, "UTF-8"));
        HttpResponse response = new DefaultHttpClient().execute(post);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        return new Gson().fromJson(reader.readLine(), Session.class);
    }

    public NestHelper refresh() throws IOException, NestSetupIncompleteException {
        mSession = logIn();
        mNestStats = getNestStats(mSession);
        List<NestValue> structures = new ValueObjectFinder().findNestValueObjects(mNestStats, StructureValueObject.class);
        mWeatherByZipcode = getLocalWeather(mSession.getUrls(), (StructureValueObject) structures.get(0));
        return this;
    }

    public SharedValueObject setAway(Session session, List<ValueObject> devices, boolean away) throws IOException {
        HttpPost post = new HttpPost(getTransportUrl(session) + "/v5/put");
        post.addHeader(addUserAgent());
        post.addHeader(addAcceptedEncoding());
        post.addHeader(addHost(UrlHelper.getHost(session.getUrls().getTransportUrl())));
        post.addHeader(addConnection());
        post.addHeader(addAuthorization(session));
        post.addHeader(addSendAuth());
        post.addHeader(addProtocolVersion());
        post.addHeader(addSessionId(session));
        post.addHeader(addUserId(session.getUserId()));
        post.addHeader(addContentType());

        Gson gson = new Gson();
        TempPayload temperatureObject = getAutoAwayObject(session, devices, away);
        String jsonPayload = gson.toJson(temperatureObject);
        post.setEntity(new StringEntity(jsonPayload, "UTF-8"));
        // HttpClient must be aware of gzip encoding
        @SuppressWarnings("deprecation")
        HttpResponse response = new ContentEncodingHttpClient().execute(post);
        checkResponse(response);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        String json = reader.readLine();
        reader.close();

        return gson.fromJson(json, SharedValueObject.class);
    }

    public SharedValueObject setNewTemp(Session session, List<ValueObject> devices, int fahrenheit) throws IOException {
        HttpPost post = new HttpPost(getTransportUrl(session) + "/v5/put");
        post.addHeader(addUserAgent());
        post.addHeader(addAcceptedEncoding());
        post.addHeader(addHost(UrlHelper.getHost(session.getUrls().getTransportUrl())));
        post.addHeader(addConnection());
        post.addHeader(addAuthorization(session));
        post.addHeader(addSendAuth());
        post.addHeader(addProtocolVersion());
        post.addHeader(addSessionId(session));
        post.addHeader(addUserId(session.getUserId()));
        post.addHeader(addContentType());

        Gson gson = new Gson();
        TempPayload temperatureObject = getTemperatureObject(session, devices, fahrenheit);
        String jsonPayload = gson.toJson(temperatureObject);
        post.setEntity(new StringEntity(jsonPayload, "UTF-8"));
        // HttpClient must be aware of gzip encoding
        @SuppressWarnings("deprecation")
        HttpResponse response = new ContentEncodingHttpClient().execute(post);
        checkResponse(response);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        String json = reader.readLine();
        reader.close();

        return gson.fromJson(json, SharedValueObject.class);
    }

    private void checkResponse(HttpResponse response) {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            System.out.println("Error status code:" + statusCode);
        }
        // TODO: throw new HttpException(statusCode);  ?
    }

    private TempPayload getTemperatureObject(Session session, List<ValueObject> devices, int fahrenheit) {
        TempPayload payload = new TempPayload();
        String userSession = String.format("android-%s-%d", session.getUserId(), System.nanoTime());
        payload.setSession(userSession);

        NestTempValues valueObject = new NestTempValues();
        valueObject.setTargetChangePending(true);
        valueObject.setTouchedBy(new TouchedByObject(5));
        valueObject.setTargetTemp(TempConversion.getCelsius(fahrenheit));

        List<ChangeTempObject> tempObjectList = new ArrayList<ChangeTempObject>(0);
        for (ValueObject device : devices) {
            ChangeTempObject changeTempObject = new ChangeTempObject();
            changeTempObject.setValue(valueObject);
            changeTempObject.setBaseObjectRevision(device.getObjectRevision());
            changeTempObject.setOp("MERGE");
            changeTempObject.setObjectKey(device.getObjectKey());
            tempObjectList.add(changeTempObject);
        }
        payload.setObjects(tempObjectList);
        return payload;
    }

    private TempPayload getAutoAwayObject(Session session, List<ValueObject> devices, boolean away) {
        TempPayload payload = new TempPayload();
        String userSession = String.format("android-%s-%d", session.getUserId(), System.nanoTime());
        payload.setSession(userSession);

        NestAutoAwayValues values = new NestAutoAwayValues();
        values.setAwaySetter(0);
        values.setTouchedByObject(new TouchedByObject(5));
        values.setAway(away);

        List<ChangeAutoAwayObject> tempObjectList = new ArrayList<ChangeAutoAwayObject>(0);
        for (ValueObject device : devices) {
            ChangeAutoAwayObject changeTempObject = new ChangeAutoAwayObject();
            changeTempObject.setValue(values);
            changeTempObject.setBaseObjectRevision(device.getObjectRevision());
            changeTempObject.setOp("MERGE");
            changeTempObject.setObjectKey(device.getObjectKey());
            tempObjectList.add(changeTempObject);
        }
        payload.setObjects(tempObjectList);
        return payload;
    }

    public NestStatus getNestStats(Session session) throws IOException {
        String transport = getTransportUrl(session);
        String url = transport + "/v5/mobile/user." + session.getUserId();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader(addAuthorization(session));
        httpGet.addHeader(addUserAgent());
        httpGet.addHeader(addAcceptedEncoding());
        httpGet.addHeader(addSendAuth());
        httpGet.addHeader(addHost(UrlHelper.getHost(url)));
        httpGet.addHeader(addConnection());
        httpGet.addHeader(addProtocolVersion());
        HttpResponse response = new ContentEncodingHttpClient().execute(httpGet);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder(0);
        String line = "";
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        NestStatusDeserializer deserializer = new NestStatusDeserializer();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ValueObject.class, deserializer);
        Gson gson = builder.create();
        return gson.fromJson(result.toString(), NestStatus.class);
    }

    private String getTransportUrl(Session session) {
        String transportWithPort = session.getUrls().getTransportUrl();
        return transportWithPort.substring(0, transportWithPort.lastIndexOf(":"));
    }

    public WeatherByZipcode getLocalWeather(Urls urls, StructureValueObject structure) throws NestSetupIncompleteException, IOException {
        if (mNestStats == null || mNestStats.getNestObjects().isEmpty()) {
            throw new NestSetupIncompleteException("Can't get weather without NestStats first...");
        }
        String zipAndCountry = String.format("%s,%s", structure.getPostalCode(), structure.getCountryCode());
        String url = String.format("%s%s", urls.getWeaterUrl(), zipAndCountry);
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader(addUserAgent());
        httpGet.addHeader(addHost(Constants.WEATHER_URL));
        httpGet.addHeader(addAcceptedEncoding());
        httpGet.addHeader(addConnection());
        HttpResponse response = new ContentEncodingHttpClient().execute(httpGet);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder result = new StringBuilder(0);
        String line = "";
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();
        WeatherDeserializer deserializer = new WeatherDeserializer(zipAndCountry);
        Gson gson = new GsonBuilder().registerTypeAdapter(WeatherByZipcode.class, deserializer).create();
        return gson.fromJson(result.toString(), WeatherByZipcode.class);
    }

    private Header addUserId(final String userId) {
        return new BasicHeader(Constants.USER_ID_KEY, userId);
    }

    private Header addSessionId(final Session session) {
        return new BasicHeader(Constants.SESSION_ID_KEY, "android-" + session.getUserId() + "-" + System.nanoTime());
    }

    private Header addContentType() {
        return new BasicHeader(Constants.CONTENT_TYPE_KEY, Constants.CONTENT_TYPE);
    }

    private Header addProtocolVersion() {
        return new BasicHeader(Constants.PROTOCOL_VERSION, String.valueOf(1));
    }

    private Header addSendAuth() {
        return new BasicHeader(Constants.SEND_AUTH_KEY, String.valueOf(true));
    }

    private Header addAuthorization(final Session session) {
        return new BasicHeader(Constants.AUTHORIZATION_KEY, "Basic " + session.getAccessToken());
    }

    private Header addConnection() {
        return new BasicHeader(Constants.CONNECTION_KEY, Constants.CONNECTION);
    }

    private Header addAcceptedEncoding() {
        return new BasicHeader(Constants.ACCEPT_ENCODING, Constants.ENCODING);
    }

    private Header addHost(final String hostUrl) {
        return new BasicHeader(Constants.HOST_KEY, hostUrl);
    }

    private Header addUserAgent() {
        return new BasicHeader(Constants.USER_AGENT_KEY, Constants.USER_AGENT);
    }
}