package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird on 3/14/14.
 */
public class Limits implements Serializable {
    @SerializedName("thermostats_per_structure")
    private int mThermostatsPerStructure;

    @SerializedName("structures")
    private int mStructures;

    @SerializedName("thermostats")
    private int mThermostats;

    @SerializedName("smoke_detectors")
    private int mSmokeDetectors;

    @SerializedName("smoke_detectors_per_structure")
    private int mSmokeDetectorsPerStructure;

    public int getThermostatsPerStructure() {
        return mThermostatsPerStructure;
    }

    public int getStructures() {
        return mStructures;
    }

    public int getThermostats() {
        return mThermostats;
    }

    public int getSmokeDetectors() {
        return mSmokeDetectors;
    }

    public int getSmokeDetectorsPerStructure() {
        return mSmokeDetectorsPerStructure;
    }
}