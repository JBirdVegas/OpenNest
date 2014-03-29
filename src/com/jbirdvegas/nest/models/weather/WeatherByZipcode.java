package com.jbirdvegas.nest.models.weather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jbird: 3/18/14
 */
public class WeatherByZipcode implements Serializable {
    @SerializedName("location")
    private Location mLocation;

    @SerializedName("current")
    private CurrentForcast mCurrentForcast;

    @SerializedName("forecast")
    private Forecast mForecast;

    public List<DailyForecast> getDailyForcast() {
        return mForecast.getDailyForecasts();
    }

    public List<HourlyForcast> getHourlyForcast() {
        return mForecast.getHourlyForcasts();
    }

    public Location getLocation() {
        return mLocation;
    }

    public CurrentForcast getCurrentForcast() {
        return mCurrentForcast;
    }
}
