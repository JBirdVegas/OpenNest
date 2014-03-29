package com.jbirdvegas.nest.models.weather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird: 3/18/14
 */
public class DailyForecast implements Serializable {
    @SerializedName("temp_low_f")
    private long mLowTempFahrenheit;

    @SerializedName("temp_low_c")
    private long mLowTempCelsius;

    @SerializedName("temp_high_f")
    private long mTempHighFahrenheit;

    @SerializedName("temp_high_c")
    private long mTempHighCelsius;

    @SerializedName("humidity")
    private int mHumidity;

    @SerializedName("wind_dir")
    private String mWindDir;

    @SerializedName("wind_kph")
    private int mWindKph;

    @SerializedName("wind_speed_std")
    private String mWindSpeedStandard;

    @SerializedName("condition")
    private String mCondition;

    @SerializedName("icon")
    private String mIcon;

    @SerializedName("date")
    private long mDate;

    public long getLowTempFahrenheit() {
        return mLowTempFahrenheit;
    }

    public long getLowTempCelsius() {
        return mLowTempCelsius;
    }

    public long getTempHighFahrenheit() {
        return mTempHighFahrenheit;
    }

    public long getTempHighCelsius() {
        return mTempHighCelsius;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public String getWindDir() {
        return mWindDir;
    }

    public int getWindKph() {
        return mWindKph;
    }

    public String getWindSpeedStandard() {
        return mWindSpeedStandard;
    }

    public String getCondition() {
        return mCondition;
    }

    public String getIcon() {
        return mIcon;
    }

    public long getDate() {
        return mDate;
    }
}
