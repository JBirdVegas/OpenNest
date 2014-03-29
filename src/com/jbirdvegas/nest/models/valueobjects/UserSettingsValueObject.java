package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;

/**
 * Created by jbird: 3/16/14
 */
public class UserSettingsValueObject extends NestValue implements Serializable {
    @SerializedName("email_verified")
    private boolean mEmailVerified;

    @SerializedName("tos_accepted_version")
    private long mTosAcceptedVersion;

    @SerializedName("receive_marketing_emails")
    private boolean mReceiveMarketingEmails;

    @SerializedName("receive_nest_emails")
    private boolean mReceiveNestEmails;

    @SerializedName("receive_support_emails")
    private boolean mReceiveSupportEmails;

    @SerializedName("max_structures")
    private int mMaxStructures;

    @SerializedName("max_thermostats")
    private int mMaxThermostats;

    @SerializedName("max_thermostats_per_structure")
    private int mMaxThermostatsPerStructure;

    @SerializedName("max_smoke_detectors_per_structure")
    private int mMaxSmokeDetectorsPerStructure;

    @SerializedName("max_smoke_detectors")
    private int mMaxSmokeDetectors;

    @SerializedName("tos_minimum_version")
    private long mTosMinimumVersion;

    @SerializedName("tos_current_version")
    private long mTosCurrentVersion;

    @SerializedName("lang")
    private String mLanguage;

    public boolean isEmailVerified() {
        return mEmailVerified;
    }

    public long getTosAcceptedVersion() {
        return mTosAcceptedVersion;
    }

    public boolean isReceiveMarketingEmails() {
        return mReceiveMarketingEmails;
    }

    public boolean isReceiveNestEmails() {
        return mReceiveNestEmails;
    }

    public boolean isReceiveSupportEmails() {
        return mReceiveSupportEmails;
    }

    public int getMaxStructures() {
        return mMaxStructures;
    }

    public int getMaxThermostats() {
        return mMaxThermostats;
    }

    public int getMaxThermostatsPerStructure() {
        return mMaxThermostatsPerStructure;
    }

    public int getMaxSmokeDetectorsPerStructure() {
        return mMaxSmokeDetectorsPerStructure;
    }

    public int getMaxSmokeDetectors() {
        return mMaxSmokeDetectors;
    }

    public long getTosMinimumVersion() {
        return mTosMinimumVersion;
    }

    public long getTosCurrentVersion() {
        return mTosCurrentVersion;
    }

    public String getLanguage() {
        return mLanguage;
    }
}
