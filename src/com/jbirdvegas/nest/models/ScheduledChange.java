package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird on 3/16/14.
 */
public class ScheduledChange implements Serializable {
    @SerializedName("touched_by")
    private int mTouchedBy;

    @SerializedName("time")
    private long mTime;

    @SerializedName("touched_tzo")
    private long mTouchedTimezone;

    @SerializedName("entry_type")
    private String mEntryType;

    @SerializedName("temp")
    private double mTemp;

    @SerializedName("type")
    private String mType;

    @SerializedName("touched_at")
    private long mTouchedAt;

    public int getTouchedBy() {
        return mTouchedBy;
    }

    public long getTime() {
        return mTime;
    }

    public long getTouchedTimezone() {
        return mTouchedTimezone;
    }

    public String getEntryType() {
        return mEntryType;
    }

    public double getTemp() {
        return mTemp;
    }

    public String getType() {
        return mType;
    }

    public long getTouchedAt() {
        return mTouchedAt;
    }
}
