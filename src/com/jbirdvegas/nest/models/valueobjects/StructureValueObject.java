package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jbird: 3/16/14
 */
public class StructureValueObject extends NestValue implements Serializable {
    @SerializedName("touched_by")
    private TouchedByObject mTouchedBy;

    @SerializedName("dr_reminder_enabled")
    private boolean mDrReminderEnabled;

    @SerializedName("renovation_date")
    private int mRenovationDate;

    @SerializedName("country_code")
    private String mCountryCode;

    @SerializedName("away_timestamp")
    private long mAwayTimestamp;

    @SerializedName("hvac_safety_shutoff_enabled")
    private boolean mHvacSaftyShutOffEnabled;

    @SerializedName("away")
    private boolean mAway;

    @SerializedName("house_type")
    private String mHouseType;

    @SerializedName("topaz_enhanced_auto_away_enabled")
    private boolean mTopezEnhancedAutoAwayEnabled;

    @SerializedName("name")
    private String mName;

    @SerializedName("postal_code")
    private int mPostalCode;

    @SerializedName("creation_time")
    private long mCreationTime;

    @SerializedName("num_thermostats")
    private int mNumberOfThermostats;

    @SerializedName("structure_area")
    private double mStructureArea;

    @SerializedName("away_setter")
    private int mAwaySetter;

    @SerializedName("user")
    private String mUser;

    @SerializedName("devices")
    private List<String> mDevices;

    @SerializedName("swarm")
    private List<String> mSwarm;

    @SerializedName("fabric_ids")
    private List<String> mFabricIds;

    public TouchedByObject getTouchedBy() {
        return mTouchedBy;
    }

    public boolean isDrReminderEnabled() {
        return mDrReminderEnabled;
    }

    public int getRenovationDate() {
        return mRenovationDate;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public long getAwayTimestamp() {
        return mAwayTimestamp;
    }

    public boolean isHvacSaftyShutOffEnabled() {
        return mHvacSaftyShutOffEnabled;
    }

    public boolean isAway() {
        return mAway;
    }

    public String getHouseType() {
        return mHouseType;
    }

    public boolean isTopezEnhancedAutoAwayEnabled() {
        return mTopezEnhancedAutoAwayEnabled;
    }

    public String getName() {
        return mName;
    }

    public int getPostalCode() {
        return mPostalCode;
    }

    public long getCreationTime() {
        return mCreationTime;
    }

    public int getNumberOfThermostats() {
        return mNumberOfThermostats;
    }

    public double getStructureArea() {
        return mStructureArea;
    }

    public int getAwaySetter() {
        return mAwaySetter;
    }

    public String getUser() {
        return mUser;
    }

    public List<String> getDevices() {
        return mDevices;
    }

    public List<String> getSwarm() {
        return mSwarm;
    }

    public List<String> getFabricIds() {
        return mFabricIds;
    }
}