package com.jbirdvegas.nest.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.jbirdvegas.nest.models.weather.WeatherByZipcode;

import java.lang.reflect.Type;

/**
 * Created by jbird: 3/18/14
 */
public class WeatherDeserializer implements JsonDeserializer<WeatherByZipcode> {

    private final String mZipcodeAndCountry;

    public WeatherDeserializer(String zipcodeAndCountry) {
        mZipcodeAndCountry = zipcodeAndCountry;
    }

    @Override
    public WeatherByZipcode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement weatherByZipJson = jsonElement.getAsJsonObject().get(mZipcodeAndCountry);
        WeatherByZipcode weatherByZipcode = new Gson().fromJson(weatherByZipJson, WeatherByZipcode.class);
        return weatherByZipcode;
    }
}