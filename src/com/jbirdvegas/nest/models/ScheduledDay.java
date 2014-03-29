package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.valueobjects.TouchedByObject;

import java.io.Serializable;

/**
 * Created by jbird: 3/17/14
 */
public class ScheduledDay implements Serializable {
    @SerializedName("touched_by")
    private TouchedByObject mTouchedByObject;

    @SerializedName("time")
    private long mTime;

    @SerializedName("touched_tzo")
    private long mTouchedTzo;

    @SerializedName("entry_type")
    private String mEntryPoint;

    @SerializedName("temp")
    private double mTemp;

    @SerializedName("type")
    private String mType;

    @SerializedName("touched_at")
    private long mTouchedAt;

    public TouchedByObject getTouchedByObject() {
        return mTouchedByObject;
    }

    public long getTime() {
        return mTime;
    }

    public long getTouchedTzo() {
        return mTouchedTzo;
    }

    public String getEntryPoint() {
        return mEntryPoint;
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
