package com.jbirdvegas.nest.models.weather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jbird: 3/18/14
 */
public class Forecast implements Serializable {
    @SerializedName("daily")
    private List<DailyForecast> mDailyForecasts;

    @SerializedName("hourly")
    private List<HourlyForcast> mHourlyForcasts;

    public List<DailyForecast> getDailyForecasts() {
        return mDailyForecasts;
    }

    public List<HourlyForcast> getHourlyForcasts() {
        return mHourlyForcasts;
    }
}
