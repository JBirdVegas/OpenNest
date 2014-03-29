package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;

/**
 * Created by jbird on 3/16/14.
 */
public class SharedValueObject extends NestValue implements Serializable {
    @SerializedName("auto_away")
    private String mAutoAway;

    @SerializedName("auto_away_learning")
    private String mAutoAwayLearning;

    @SerializedName("hvac_heat_x3_state")
    private boolean mHvacHeatx3State;

    @SerializedName("compressor_lockout_enabled")
    private boolean mCompressorLockoutEnabled;

    @SerializedName("hvac_heater_state")
    private boolean mHvacHeaterState;

    @SerializedName("can_heat")
    private boolean mCanHeat;

    // Emergency heater is On?
    @SerializedName("hvac_emer_heat_state")
    private boolean mHvacEmerHeateState;

    @SerializedName("compressor_lockout_timeout")
    private long mCompressorLockoutTimeout;

    @SerializedName("hvac_cool_x2_state")
    private boolean HvacCoolx2State;

    @SerializedName("target_temperature_high")
    private double mTargetTemperatureHigh;

    @SerializedName("hvac_aux_heater_state")
    private boolean mHvacAuxHeaterState;

    @SerializedName("hvac_heat_x2_state")
    private boolean mHvacHeatx2State;

    @SerializedName("target_temperature_low")
    private double mTargetTemperatureLow;

    @SerializedName("hvac_ac_state")
    private boolean mHvacAcState;

    @SerializedName("hvac_fan_state")
    private boolean mHvacFanState;

    @SerializedName("name")
    private String mName;

    @SerializedName("current_temperature")
    private double mCurrentTemp;

    @SerializedName("hvac_alt_heat_x2_state")
    private boolean mHvacAltHeatx2State;

    @SerializedName("can_cool")
    private boolean mCanCool;

    @SerializedName("structure")
    private String mStructure;

    public String getAutoAway() {
        return mAutoAway;
    }

    public String getAutoAwayLearning() {
        return mAutoAwayLearning;
    }

    public boolean isHvacHeatx3State() {
        return mHvacHeatx3State;
    }

    public boolean isCompressorLockoutEnabled() {
        return mCompressorLockoutEnabled;
    }

    public boolean isHvacHeaterState() {
        return mHvacHeaterState;
    }

    public boolean isCanHeat() {
        return mCanHeat;
    }

    public boolean isHvacEmerHeateState() {
        return mHvacEmerHeateState;
    }

    public long getCompressorLockoutTimeout() {
        return mCompressorLockoutTimeout;
    }

    public boolean isHvacCoolx2State() {
        return HvacCoolx2State;
    }

    public double getTargetTemperatureHigh() {
        return mTargetTemperatureHigh;
    }

    public boolean isHvacAuxHeaterState() {
        return mHvacAuxHeaterState;
    }

    public boolean isHvacHeatx2State() {
        return mHvacHeatx2State;
    }

    public double getTargetTemperatureLow() {
        return mTargetTemperatureLow;
    }

    public boolean isHvacAcState() {
        return mHvacAcState;
    }

    public boolean isHvacFanState() {
        return mHvacFanState;
    }

    public String getName() {
        return mName;
    }

    public double getCurrentTemp() {
        return mCurrentTemp;
    }

    public boolean isHvacAltHeatx2State() {
        return mHvacAltHeatx2State;
    }

    public boolean isCanCool() {
        return mCanCool;
    }

    public String getStructure() {
        return mStructure;
    }
}
