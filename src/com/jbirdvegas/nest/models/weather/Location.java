package com.jbirdvegas.nest.models.weather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird: 3/18/14
 */
public class Location implements Serializable {
    @SerializedName("station_id")
    private String mStationId;

    @SerializedName("zip")
    private int mZip;

    @SerializedName("city")
    private String mCity;

    @SerializedName("state")
    private String mState;

    @SerializedName("country")
    private String mCountry;

    @SerializedName("lat")
    private String mLat;

    @SerializedName("lon")
    private String mLong;

    @SerializedName("short_name")
    private String mShortName;

    @SerializedName("timezone")
    private String mTimezone;

    @SerializedName("timezone_long")
    private String mTimezoneLong;

    @SerializedName("gcm_offset")
    private String mGcmOffset;

    @SerializedName("full_name")
    private String mFullName;

    public String getStationId() {
        return mStationId;
    }

    public int getZip() {
        return mZip;
    }

    public String getCity() {
        return mCity;
    }

    public String getState() {
        return mState;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getLat() {
        return mLat;
    }

    public String getLong() {
        return mLong;
    }

    public String getShortName() {
        return mShortName;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public String getTimezoneLong() {
        return mTimezoneLong;
    }

    public String getGcmOffset() {
        return mGcmOffset;
    }

    public String getFullName() {
        return mFullName;
    }
}