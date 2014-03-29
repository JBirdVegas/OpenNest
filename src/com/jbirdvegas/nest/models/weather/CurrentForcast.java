package com.jbirdvegas.nest.models.weather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird: 3/18/14
 */
public class CurrentForcast implements Serializable {
    /*
         "temp_f":42.1,
         "temp_c":5.6,
         "condition":"Light Rain",
         "sunrise":1394970926,
         "sunset":1395014063,
         "lengthofday":718,
         "humidity":95,
         "timezone":"CDT",
         "gmt_offset":"-5.00",
         "wind_dir":"NNE",
         "wind_mph":1.0,
         "wind_kph":1.6,
         "observation_time":1395006303,
         "icon":"rain"
     */
    @SerializedName("temp_f")
    private double mTempFahrenheit;

    @SerializedName("temp_c")
    private double mTempCelsius;

    @SerializedName("condition")
    private String mCondition;

    @SerializedName("sunrise")
    private long mSunrise;

    @SerializedName("sunset")
    private long mSunset;

    @SerializedName("lengthofday")
    private int mLengthOfDay;

    @SerializedName("humidity")
    private int mHumidity;

    @SerializedName("timezone")
    private String mTimezone;

    @SerializedName("gmt_offset")
    private String mGmtOffset;

    @SerializedName("wind_dir")
    private String mWindDir;

    @SerializedName("wind_mph")
    private double mWindMph;

    @SerializedName("wind_kph")
    private double mWindKph;

    @SerializedName("observation_time")
    private long mObservationTime;

    @SerializedName("icon")
    private String mIcon;

    public double getTempFahrenheit() {
        return mTempFahrenheit;
    }

    public double getTempCelsius() {
        return mTempCelsius;
    }

    public String getCondition() {
        return mCondition;
    }

    public long getSunrise() {
        return mSunrise;
    }

    public long getSunset() {
        return mSunset;
    }

    public int getLengthOfDay() {
        return mLengthOfDay;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public String getGmtOffset() {
        return mGmtOffset;
    }

    public String getWindDir() {
        return mWindDir;
    }

    public double getWindMph() {
        return mWindMph;
    }

    public double getWindKph() {
        return mWindKph;
    }

    public long getObservationTime() {
        return mObservationTime;
    }

    public String getIcon() {
        return mIcon;
    }
}
