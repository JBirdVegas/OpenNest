package com.jbirdvegas.nest.models.weather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird: 3/18/14
 */
public class HourlyForcast implements Serializable {
    @SerializedName("hour")
    private int mHour;

    @SerializedName("date")
    private String mDate;

    @SerializedName("temp_f")
    private int mTempFahrenheit;

    @SerializedName("temp_c")
    private int mTempCelsius;

    @SerializedName("humidity")
    private int mHumidity;

    @SerializedName("time")
    private long mTime;

    @SerializedName("wind_dir")
    private String mWindDir;

    public int getHour() {
        return mHour;
    }

    public String getDate() {
        return mDate;
    }

    public int getTempFahrenheit() {
        return mTempFahrenheit;
    }

    public int getTempCelsius() {
        return mTempCelsius;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public long getTime() {
        return mTime;
    }

    public String getWindDir() {
        return mWindDir;
    }
}
