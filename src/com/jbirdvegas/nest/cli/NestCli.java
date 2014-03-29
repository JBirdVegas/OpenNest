package com.jbirdvegas.nest.cli;

import com.google.gson.GsonBuilder;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.exceptions.NestSetupIncompleteException;
import com.jbirdvegas.nest.models.NestStatus;
import com.jbirdvegas.nest.models.Session;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.models.valueobjects.StructureValueObject;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;
import com.jbirdvegas.nest.models.weather.WeatherByZipcode;
import com.jbirdvegas.nest.utils.ValueObjectFinder;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jbird: 3/17/14
 */
public class NestCli {
    private NestHelper mHelper;
    private Session mSession;

    // Use args4j (https://github.com/kohsuke/args4j) to simplify argument parsing
    @Option(name = "-email", usage = "Email address of Nest account.")
    private String mUsername;
    
    @Option(name="-pass", usage = "Nest password associated with provided email address")
    private String mPassword;
    
    @Option(name = "-temp", usage = "Target temperature (F\u00B0) to set Nest devices")
    private int mTemp;

    @Option(name = "-away", usage = "Set Nest devices to away (true|false)")
    private boolean mAway = false;

    @Option(name = "-d", usage = "Show debugging output")
    private boolean mDebug = false;

    // receives other command line parameters than options
    @Argument
    private List<String> mArguments = new ArrayList<String>(0);

    public void main(String[] args) throws Exception {
        CmdLineParser parser = new CmdLineParser(this);
        // default Console width
        parser.setUsageWidth(80);
        parser.parseArgument(args);
        if (!mArguments.isEmpty()) {
            new NestCli().run();
        } else {
            new NestCli().runWithPrompts();
        }
    }

    // Sets Nest devices based on user input prompts at Runtime
    private void runWithPrompts() throws IOException {
        mUsername = getInput("Please enter your email: ");
        mPassword = getPassword("Please enter your password: ");

        String debuggingInfo = getInput("Should we show debugging info? (y|n) ");
        mDebug = debuggingInfo.equalsIgnoreCase("y") || debuggingInfo.equalsIgnoreCase("yes");

        try {
            mHelper = new NestHelper(mUsername, mPassword);
            mSession = mHelper.getSession();
            logDebug(mSession);
            NestStatus nestStats = mHelper.getNestStats();
            logDebug(nestStats);

            String input = getInput("Should we set devices as away? (y|n) ");
            boolean away = input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
            setAway(nestStats, away);
            if (away) {
                return;
            }

            setNewTemp(nestStats, getNewTemp("What temperature would you like to set your Nest(s)? "));

            StructureValueObject structure = (StructureValueObject) new ValueObjectFinder()
                    .findNestValueObjects(nestStats, StructureValueObject.class).get(0);
            WeatherByZipcode localWeather = mHelper.getLocalWeather(mSession.getUrls(), structure);
            logDebug(localWeather);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NestSetupIncompleteException e) {
            e.printStackTrace();
        }
    }

    // sets Nest devices based on Command line provided args
    private void run() throws IOException {
        try {
            mHelper = new NestHelper(mUsername, mPassword);
            mSession = mHelper.getSession();
            logDebug(mSession);

            NestStatus nestStats = mHelper.getNestStats();
            logDebug(nestStats);
            setAway(nestStats, mAway);
            if (mAway) {
                return;
            }
            setNewTemp(nestStats, mTemp);

            // TODO: Should we show weather if user is setting devices with CLI Args?
//            StructureValueObject structure = (StructureValueObject) new ValueObjectFinder()
//                    .findNestValueObjects(mHelper.getNestStats(), StructureValueObject.class).get(0);
//            WeatherByZipcode localWeather = mHelper.getLocalWeather(mSession.getUrls(), structure);
//            logDebug(localWeather);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NestSetupIncompleteException e) {
            e.printStackTrace();
        }
    }
    
    private void setNewTemp(NestStatus nestStats, int temp) throws IOException {
        List<ValueObject> devices = new ValueObjectFinder().findValueObjects(nestStats, SharedValueObject.class);
        List<ValueObject> room = new ArrayList<ValueObject>(0);
        for (ValueObject obj : devices) {
            // TODO add some smart selection of devices
            room.add(obj);
        }
        SharedValueObject sharedValueObject = mHelper.setNewTemp(mSession, room, temp);
        logDebug(sharedValueObject);
    }

    private void setAway(NestStatus nestStats, boolean away) throws IOException {
        List<ValueObject> devices = new ValueObjectFinder().findValueObjects(nestStats, StructureValueObject.class);
        List<ValueObject> room = new ArrayList<ValueObject>(0);
        for (ValueObject obj : devices) {
            // TODO add some smart selection of devices
            room.add(obj);
        }
        SharedValueObject sharedValueObject = mHelper.setAway(mSession, room, away);
        logDebug(sharedValueObject);
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).next();
    }

    public String getPassword(String prompt) throws IOException {
        Console c=System.console();
        // in case we are being ran from within an IDE... shows password :(
        if (c==null) {
            System.out.print(prompt);
            InputStream in=System.in;
            int max=50;
            byte[] b=new byte[max];

            int l= in.read(b);
            l--;//last character is \n
            if (l>0) {
                byte[] e=new byte[l];
                System.arraycopy(b,0, e, 0, l);
                return new String(e);
            } else {
                return null;
            }
        // We were ran from a command line... no password shown :D
        } else {
            return new String(c.readPassword(prompt));
        }
    }
    public int getNewTemp(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextInt();
    }

    public void logDebug(Object gsonObject) {
        if (mDebug) {
            String json = new GsonBuilder().setPrettyPrinting().create().toJson(gsonObject);
            System.out.println(json);
        }
    }
}