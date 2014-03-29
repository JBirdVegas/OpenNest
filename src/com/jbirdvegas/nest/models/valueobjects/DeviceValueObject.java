package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jbird: 3/16/14
 */
public class DeviceValueObject extends NestValue implements Serializable {
    @SerializedName("heatpump_setback_active")
    private boolean mHeatpumpSetbackActive;

    @SerializedName("touched_by")
    private TouchedByObject mTouchedByObject;

    @SerializedName("emmer_heat_enable")
    private boolean mEmmerHeatEnable;

    @SerializedName("switch_system_off")
    private boolean mSwitchSystemOff;

    @SerializedName("local_ip")
    private String mLocalIp;

    @SerializedName("away_temperature_high")
    private double mAwayTemperatureHigh;

    @SerializedName("y2_type")
    private String mY2Type;

    @SerializedName("temperature_lock_high_temp")
    private double mTemperatureLockHighTemp;

    @SerializedName("cooling_source")
    private String mCoolingSource;

    @SerializedName("leaf_threashold_cool")
    private double mLeafThreasholdCool;

    @SerializedName("note_codes")
    private List<String> mNoteCodes;

    @SerializedName("fan_cooling_state")
    private boolean mFanCoolingState;

    @SerializedName("heater_source")
    private String mHeaterSource;

    @SerializedName("compressor_lockout_leaf")
    private double mCompressorLockoutLeaf;

    @SerializedName("has_x3_source")
    private boolean mHasx3Source;

    @SerializedName("target_humidity_enabled")
    private boolean mTargetHumidityEnabled;

    @SerializedName("heat_x3_source")
    private String mHeatx3Source;

    @SerializedName("alt_heat_delivery")
    private String mAltHeatDelivery;

    @SerializedName("fan_mode")
    private String mFanMode;

    @SerializedName("has_x2_heat")
    private String mHasx2Heat;

    @SerializedName("sunlight_correction_active")
    private boolean mSunlightCorrectionActive;

    @SerializedName("rssi")
    private double mRssi;

    @SerializedName("emer_heat_delivery")
    private String mEmerHeatDelivery;

    @SerializedName("pin_y2_description")
    private String mPiny2Description;

    @SerializedName("heatpump_savings")
    private String mHeatpumpSavings;

    @SerializedName("humidity_control_lockout_end_time")
    private long mHumidityControlLockoutEndTime;

    @SerializedName("filter_reminder_level")
    private double mFilterReminderLevel;

    @SerializedName("filter_reminder_enabled")
    private boolean mFilterReminderEnabled;

    @SerializedName("capability_level")
    private double mCapabilityLevel;

    @SerializedName("schedule_learning_reset")
    private boolean mSchedultLearningReset;

    @SerializedName("has_x2_cool")
    private boolean mHasx2Cool;

    @SerializedName("ob_orientation")
    private String mObOrientation;

    @SerializedName("hvac_pins")
    private String mHvacPins;

    @SerializedName("cooling_delivery")
    private String mCoolingDelivery;

    @SerializedName("range_enabled")
    private boolean mRangeEnabled;

    @SerializedName("dual_fuel_breakpoint_override")
    private String mDualFuelBreakpointOverride;

    @SerializedName("auto_away_enable")
    private boolean mAutoAwayEnable;

    @SerializedName("lower_safety_temp_enabled")
    private boolean mLowerSafetyTempEnabled;

    @SerializedName("has_fan")
    private boolean mHasFan;

    @SerializedName("dehumidifier_state")
    private boolean mDehumidifierState;

    @SerializedName("nlclient_state")
    private String mNlClientState;

    @SerializedName("emer_heat_source")
    private String mEmerHeatSource;

    @SerializedName("heatpump_ready")
    private boolean mHeatpumpReady;

    @SerializedName("cooling_x2_delivery")
    private String mCoolingx2Delivery;

    // example: "en_US,fr_CA,es_US",
    @SerializedName("available_locales")
    private String mAvailableLocales;

    @SerializedName("current_version")
    private String mCurrentVersion;

    @SerializedName("learning_state")
    private String mLearningState;

    @SerializedName("has_fossil_fuel")
    private boolean mHasFossilFuel;

    @SerializedName("pin_rh_description")
    private String mPinRhDescription;

    @SerializedName("pin_ob_description")
    private String mPinObDescription;

    @SerializedName("safety_temp_activation_hvac")
    private boolean mSafetyTempActivationHvac;

    @SerializedName("has_alt_heat")
    private boolean mHasAltHeat;

    @SerializedName("fan_duty_cycle")
    private int mFanDutyCycle;

    @SerializedName("pin_y1_description")
    private String mPiny1Description;

    @SerializedName("humidifier_state")
    private boolean mHumidifierState;

    @SerializedName("gear_threshold_heat")
    private double mGearThresholdHeat;

    @SerializedName("backplate_serial_number")
    private String mBackplateSerialNumber;

    @SerializedName("has_x2_alt_heat")
    private boolean mHasx2AltHeat;

    @SerializedName("leaf_threshold_heat")
    private double mLeafThresholdHeat;

    @SerializedName("heat_x3_delivery")
    private String mHeatx3Delivery;

    @SerializedName("learning_mode")
    private boolean mLearningMode;

    @SerializedName("has_emer_heat")
    private boolean mHasEmerHeat;

    @SerializedName("leaf_learning")
    private String mLeafLearning;

    @SerializedName("has_aux_heat")
    private boolean mHasAuxHeat;

    @SerializedName("aux_heat_source")
    private String mAuxHeatSource;

    @SerializedName("filter_changed_set_date")
    private long mFilterChangedSetDate;

    @SerializedName("backplate_bsl_info")
    private String mBackplateBslInfo;

    @SerializedName("sunlight_correction_ready")
    private boolean mSunlightCorrectionReady;

    @SerializedName("alt_heat_x2_source")
    private String mAltHeatx2Source;

    @SerializedName("pin_c_description")
    private String mPinCDescription;

    @SerializedName("humidifier_type")
    private String mHumidifierType;

    @SerializedName("pin_w2aux_description")
    private String mPinw2AuxDescription;

    @SerializedName("humidity_control_lockout_start_time")
    private long mHumidityControlLockoutStartTime;

    @SerializedName("sunlight_correction_enabled")
    private boolean mSunlightCorrectionEnabled;

    @SerializedName("country_code")
    private String mCountryCode;

    @SerializedName("fan_timer")
    private long mFanTimer;

    @SerializedName("target_humididty")
    private double mTargetHumidity;

    @SerializedName("heat_x2_delivery")
    private String mHeatx2Delivery;

    @SerializedName("gear_treshold_low")
    private double mGearThresholdLow;

    @SerializedName("lower_safety_temp")
    private double mLowerSafetyTemp;

    @SerializedName("cooling_x2_source")
    private String mCoolingx2Source;

    @SerializedName("equipment_type")
    private String mEquipmentType;

    @SerializedName("heat_pump_aux_threshold")
    private double mHeatPumpAuxThreshold;

    @SerializedName("alt_heat_x2_delivery")
    private String mAltHeatx2Delivery;

    @SerializedName("heat_pump_comp_threshold")
    private double mHeatPumpCompThreshold;

    @SerializedName("learning_days_completed_cool")
    private int mLearningDaysCompletedCool;

    @SerializedName("backplate_bsl_version")
    private String mBackplateBlsVersion;

    @SerializedName("current_schedule_mode")
    private String mCurrentScheduleMode;

    @SerializedName("hvac_wires")
    private String mHvacWires;

    @SerializedName("fan_duty_end_time")
    private long mFanDutyEndTime;

    @SerializedName("leaf")
    private boolean mLeaf;

    @SerializedName("type")
    private String mType;

    @SerializedName("pin_g_description")
    private String mPinGDescription;

    @SerializedName("click_sound")
    private String mClickSound;

    @SerializedName("aux_heat_delivery")
    private String mAuxHeatDelivery;

    @SerializedName("away_temperature_low_enabled")
    private boolean mAwayTemperatureLowEnabled;

    @SerializedName("filter_changed_date")
    private long mFilterChangedDate;

    @SerializedName("hvac_safety_shutoff_enabled")
    private boolean mHvacSafetyShutoffEnabled;

    @SerializedName("heat_pump_comp_threshold_enabled")
    private boolean mHeatPumpCompThresholdEnabled;

    @SerializedName("preconditioning_ready")
    private boolean mPreconditioningReady;

    @SerializedName("has_dehumidifier")
    private boolean mHasDehumidifier;

    @SerializedName("fan_cooling_enabled")
    private boolean mFanCoolingEnabled;

    @SerializedName("leaf_away_high")
    private double mLeafAwayHigh;

    @SerializedName("fan_cooling_readiness")
    private String mFanCoolingReadiness;

    // { C | F }
    @SerializedName("temperature_scale")
    private char mTemperatureScale;

    @SerializedName("device_locale")
    private String mDeviceLocale;

    @SerializedName("preconditioning_active")
    private boolean mPreconditioningActive;

    @SerializedName("maint_band_upper")
    private double mMaintBandUpper;

    @SerializedName("error_code")
    private String mErrorCode;

    @SerializedName("battery_level")
    private double mBatteryLevel;

    @SerializedName("fan_control_state")
    private boolean mFanControlState;

    @SerializedName("away_temperature_high_enabled")
    private boolean mAwayTemperatureHighEnabled;

    @SerializedName("learning_days_completed_heat")
    private int mLearningDaysCompletedHeat;

    @SerializedName("humidifier_fan_activation")
    private boolean mHumidifierFanActivation;

    @SerializedName("upper_safety_temp_enabled")
    private boolean mUpperSafetyTempEnabled;

    @SerializedName("pin_star_description")
    private String mPinStarDescription;

    @SerializedName("preconditioning_enabled")
    private boolean mPreconditioningEnabled;

    @SerializedName("dual_fuel_breakpoint")
    private double mDualFuelBreakpoint;

    @SerializedName("current_humidity")
    private long mCurrentHumidity;

    @SerializedName("postal_code")
    private int mPostalCode;

    @SerializedName("alt_heat_source")
    private String mAltHeatSource;

    @SerializedName("backplate_mono_version")
    private String mBackplateMonoVersion;

    @SerializedName("aux_lockout_leaf")
    private double mAuxLockoutLeaf;

    @SerializedName("has_heat_pump")
    private boolean mHasHeatPump;

    @SerializedName("heater_delivery")
    private String mHeaterDelivery;

    @SerializedName("radiant_control_enabled")
    private boolean mRadiantControlEnabled;

    @SerializedName("auto_away_reset")
    private boolean mAutoAwayReset;

    @SerializedName("away_temperature_low")
    private double mAwayTemperatureLow;

    @SerializedName("temperature_lock")
    private boolean mTemperatureLock;

    @SerializedName("has_air_filter")
    private boolean mHasAirFilter;

    @SerializedName("upper_safety_temp")
    private double mUpperSafetyTemp;

    @SerializedName("time_to_target_training")
    private String mTimeToTargetTraining;

    @SerializedName("dehumidifier_type")
    private String mDehumidifierType;

    @SerializedName("humidity_control_lockout_enabled")
    private boolean mHumidityControlLockoutEnabled;

    @SerializedName("target_time_confidence")
    private double mTargetTimeConfidence;

    @SerializedName("fan_timer_duration")
    private long mFanTimerDuration;

    @SerializedName("temperature_lock_low_temp")
    private double mTemperatureLockLowTemp;

    @SerializedName("pin_w1_description")
    private String mPinw1Description;

    @SerializedName("forced_air")
    private boolean mForcedAir;

    @SerializedName("temperature_lock_pin_hash")
    private String mTemperatureLockPinHash;

    @SerializedName("auto_dehum_enabled")
    private boolean mAutoDehumEnabled;

    @SerializedName("backplate_mono_info")
    private String mBackplateMonoInfo;

    @SerializedName("star_type")
    private String mStarType;

    @SerializedName("has_dual_fuel")
    private boolean mHasDualFuel;

    @SerializedName("maint_band_lower")
    private double mMaintBandLower;

    @SerializedName("learning_time")
    private long mLearningTime;

    @SerializedName("creation_time")
    private long mCreationTime;

    @SerializedName("has_humidifier")
    private boolean mHasHumidifier;

    @SerializedName("learning_days_completed_range")
    private int mLearningDaysCompletedRange;

    @SerializedName("dehumidifier_orientation_selected")
    private String mDehumidifierOrientationSelected;

    @SerializedName("leaf_schedule_delta")
    private double mLeafScheduleDelta;

    @SerializedName("logging_priority")
    private String mLoggingPriority;

    @SerializedName("user_brightness")
    private String mUserBrighness;

    @SerializedName("leaf_away_low")
    private double mLeafAwayLow;

    @SerializedName("pin_rc_description")
    private String mPinRcDescription;

    @SerializedName("serial_number")
    private String mSerialNumber;

    @SerializedName("auto_dehum_state")
    private boolean mAutoDehumState;

    @SerializedName("mac_address")
    private String mMacAddress;

    @SerializedName("heat_x2_source")
    private String mHeatx2Source;

    @SerializedName("fan_duty_start_time")
    private long mFanDutyStartTime;

    @SerializedName("time_to_target")
    private long mTimeToTarget;

    @SerializedName("backplate_model")
    private String mBackplateModel;

    @SerializedName("model_version")
    private String mModelVersion;

    @SerializedName("heat_pump_aux_threshold_enabled")
    private boolean mHeatPumpAuxThresholdEnabled;

    @SerializedName("ob_persistence")
    private boolean mObPersistence;

    public boolean isHeatpumpSetbackActive() {
        return mHeatpumpSetbackActive;
    }

    public TouchedByObject getTouchedByObject() {
        return mTouchedByObject;
    }

    public boolean isEmmerHeatEnable() {
        return mEmmerHeatEnable;
    }

    public boolean isSwitchSystemOff() {
        return mSwitchSystemOff;
    }

    public String getLocalIp() {
        return mLocalIp;
    }

    public double getAwayTemperatureHigh() {
        return mAwayTemperatureHigh;
    }

    public String getY2Type() {
        return mY2Type;
    }

    public double getTemperatureLockHighTemp() {
        return mTemperatureLockHighTemp;
    }

    public String getCoolingSource() {
        return mCoolingSource;
    }

    public double getLeafThreasholdCool() {
        return mLeafThreasholdCool;
    }

    public List<String> getNoteCodes() {
        return mNoteCodes;
    }

    public boolean isFanCoolingState() {
        return mFanCoolingState;
    }

    public String getHeaterSource() {
        return mHeaterSource;
    }

    public double getCompressorLockoutLeaf() {
        return mCompressorLockoutLeaf;
    }

    public boolean isHasx3Source() {
        return mHasx3Source;
    }

    public boolean isTargetHumidityEnabled() {
        return mTargetHumidityEnabled;
    }

    public String getHeatx3Source() {
        return mHeatx3Source;
    }

    public String getAltHeatDelivery() {
        return mAltHeatDelivery;
    }

    public String getFanMode() {
        return mFanMode;
    }

    public String getHasx2Heat() {
        return mHasx2Heat;
    }

    public boolean isSunlightCorrectionActive() {
        return mSunlightCorrectionActive;
    }

    public double getRssi() {
        return mRssi;
    }

    public String getEmerHeatDelivery() {
        return mEmerHeatDelivery;
    }

    public String getPiny2Description() {
        return mPiny2Description;
    }

    public String getHeatpumpSavings() {
        return mHeatpumpSavings;
    }

    public long getHumidityControlLockoutEndTime() {
        return mHumidityControlLockoutEndTime;
    }

    public double getFilterReminderLevel() {
        return mFilterReminderLevel;
    }

    public boolean isFilterReminderEnabled() {
        return mFilterReminderEnabled;
    }

    public double getCapabilityLevel() {
        return mCapabilityLevel;
    }

    public boolean isSchedultLearningReset() {
        return mSchedultLearningReset;
    }

    public boolean isHasx2Cool() {
        return mHasx2Cool;
    }

    public String getObOrientation() {
        return mObOrientation;
    }

    public String getHvacPins() {
        return mHvacPins;
    }

    public String getCoolingDelivery() {
        return mCoolingDelivery;
    }

    public boolean isRangeEnabled() {
        return mRangeEnabled;
    }

    public String getDualFuelBreakpointOverride() {
        return mDualFuelBreakpointOverride;
    }

    public boolean isAutoAwayEnable() {
        return mAutoAwayEnable;
    }

    public boolean isLowerSafetyTempEnabled() {
        return mLowerSafetyTempEnabled;
    }

    public boolean isHasFan() {
        return mHasFan;
    }

    public boolean isDehumidifierState() {
        return mDehumidifierState;
    }

    public String getNlClientState() {
        return mNlClientState;
    }

    public String getEmerHeatSource() {
        return mEmerHeatSource;
    }

    public boolean isHeatpumpReady() {
        return mHeatpumpReady;
    }

    public String getCoolingx2Delivery() {
        return mCoolingx2Delivery;
    }

    public String getAvailableLocales() {
        return mAvailableLocales;
    }

    public String getCurrentVersion() {
        return mCurrentVersion;
    }

    public String getLearningState() {
        return mLearningState;
    }

    public boolean isHasFossilFuel() {
        return mHasFossilFuel;
    }

    public String getPinRhDescription() {
        return mPinRhDescription;
    }

    public String getPinObDescription() {
        return mPinObDescription;
    }

    public boolean isSafetyTempActivationHvac() {
        return mSafetyTempActivationHvac;
    }

    public boolean isHasAltHeat() {
        return mHasAltHeat;
    }

    public int getFanDutyCycle() {
        return mFanDutyCycle;
    }

    public String getPiny1Description() {
        return mPiny1Description;
    }

    public boolean isHumidifierState() {
        return mHumidifierState;
    }

    public double getGearThresholdHeat() {
        return mGearThresholdHeat;
    }

    public String getBackplateSerialNumber() {
        return mBackplateSerialNumber;
    }

    public boolean isHasx2AltHeat() {
        return mHasx2AltHeat;
    }

    public double getLeafThresholdHeat() {
        return mLeafThresholdHeat;
    }

    public String getHeatx3Delivery() {
        return mHeatx3Delivery;
    }

    public boolean isLearningMode() {
        return mLearningMode;
    }

    public boolean isHasEmerHeat() {
        return mHasEmerHeat;
    }

    public String getLeafLearning() {
        return mLeafLearning;
    }

    public boolean isHasAuxHeat() {
        return mHasAuxHeat;
    }

    public String getAuxHeatSource() {
        return mAuxHeatSource;
    }

    public long getFilterChangedSetDate() {
        return mFilterChangedSetDate;
    }

    public String getBackplateBslInfo() {
        return mBackplateBslInfo;
    }

    public boolean isSunlightCorrectionReady() {
        return mSunlightCorrectionReady;
    }

    public String getAltHeatx2Source() {
        return mAltHeatx2Source;
    }

    public String getPinCDescription() {
        return mPinCDescription;
    }

    public String getHumidifierType() {
        return mHumidifierType;
    }

    public String getPinw2AuxDescription() {
        return mPinw2AuxDescription;
    }

    public long getHumidityControlLockoutStartTime() {
        return mHumidityControlLockoutStartTime;
    }

    public boolean isSunlightCorrectionEnabled() {
        return mSunlightCorrectionEnabled;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public long getFanTimer() {
        return mFanTimer;
    }

    public double getTargetHumidity() {
        return mTargetHumidity;
    }

    public String getHeatx2Delivery() {
        return mHeatx2Delivery;
    }

    public double getGearThresholdLow() {
        return mGearThresholdLow;
    }

    public double getLowerSafetyTemp() {
        return mLowerSafetyTemp;
    }

    public String getCoolingx2Source() {
        return mCoolingx2Source;
    }

    public String getEquipmentType() {
        return mEquipmentType;
    }

    public double isHeatPumpAuxThreshold() {
        return mHeatPumpAuxThreshold;
    }

    public String getAltHeatx2Delivery() {
        return mAltHeatx2Delivery;
    }

    public double getHeatPumpCompThreshold() {
        return mHeatPumpCompThreshold;
    }

    public int getLearningDaysCompletedCool() {
        return mLearningDaysCompletedCool;
    }

    public String getBackplateBlsVersion() {
        return mBackplateBlsVersion;
    }

    public String getCurrentScheduleMode() {
        return mCurrentScheduleMode;
    }

    public String getHvacWires() {
        return mHvacWires;
    }

    public long getFanDutyEndTime() {
        return mFanDutyEndTime;
    }

    public boolean isLeaf() {
        return mLeaf;
    }

    public String getType() {
        return mType;
    }

    public String getPinGDescription() {
        return mPinGDescription;
    }

    public String getClickSound() {
        return mClickSound;
    }

    public String getAuxHeatDelivery() {
        return mAuxHeatDelivery;
    }

    public boolean isAwayTemperatureLowEnabled() {
        return mAwayTemperatureLowEnabled;
    }

    public long getFilterChangedDate() {
        return mFilterChangedDate;
    }

    public boolean isHvacSafetyShutoffEnabled() {
        return mHvacSafetyShutoffEnabled;
    }

    public boolean isHeatPumpCompThresholdEnabled() {
        return mHeatPumpCompThresholdEnabled;
    }

    public boolean isPreconditioningReady() {
        return mPreconditioningReady;
    }

    public boolean isHasDehumidifier() {
        return mHasDehumidifier;
    }

    public boolean isFanCoolingEnabled() {
        return mFanCoolingEnabled;
    }

    public double getLeafAwayHigh() {
        return mLeafAwayHigh;
    }

    public String getFanCoolingReadiness() {
        return mFanCoolingReadiness;
    }

    public char getTemperatureScale() {
        return mTemperatureScale;
    }

    public String getDeviceLocale() {
        return mDeviceLocale;
    }

    public boolean isPreconditioningActive() {
        return mPreconditioningActive;
    }

    public double getMaintBandUpper() {
        return mMaintBandUpper;
    }

    public String getErrorCode() {
        return mErrorCode;
    }

    public double getBatteryLevel() {
        return mBatteryLevel;
    }

    public boolean isFanControlState() {
        return mFanControlState;
    }

    public boolean isAwayTemperatureHighEnabled() {
        return mAwayTemperatureHighEnabled;
    }

    public int isLearningDaysCompletedHeat() {
        return mLearningDaysCompletedHeat;
    }

    public boolean isHumidifierFanActivation() {
        return mHumidifierFanActivation;
    }

    public boolean isUpperSafetyTempEnabled() {
        return mUpperSafetyTempEnabled;
    }

    public String getPinStarDescription() {
        return mPinStarDescription;
    }

    public boolean isPreconditioningEnabled() {
        return mPreconditioningEnabled;
    }

    public double getDualFuelBreakpoint() {
        return mDualFuelBreakpoint;
    }

    public long getCurrentHumidity() {
        return mCurrentHumidity;
    }

    public int getPostalCode() {
        return mPostalCode;
    }

    public String getAltHeatSource() {
        return mAltHeatSource;
    }

    public String getBackplateMonoVersion() {
        return mBackplateMonoVersion;
    }

    public double getAuxLockoutLeaf() {
        return mAuxLockoutLeaf;
    }

    public boolean isHasHeatPump() {
        return mHasHeatPump;
    }

    public String getHeaterDelivery() {
        return mHeaterDelivery;
    }

    public boolean isRadiantControlEnabled() {
        return mRadiantControlEnabled;
    }

    public boolean isAutoAwayReset() {
        return mAutoAwayReset;
    }

    public double getAwayTemperatureLow() {
        return mAwayTemperatureLow;
    }

    public boolean isTemperatureLock() {
        return mTemperatureLock;
    }

    public boolean isHasAirFilter() {
        return mHasAirFilter;
    }

    public double getUpperSafetyTemp() {
        return mUpperSafetyTemp;
    }

    public String getTimeToTargetTraining() {
        return mTimeToTargetTraining;
    }

    public String getDehumidifierType() {
        return mDehumidifierType;
    }

    public boolean isHumidityControlLockoutEnabled() {
        return mHumidityControlLockoutEnabled;
    }

    public double getTargetTimeConfidence() {
        return mTargetTimeConfidence;
    }

    public long getFanTimerDuration() {
        return mFanTimerDuration;
    }

    public double getTemperatureLockLowTemp() {
        return mTemperatureLockLowTemp;
    }

    public String getPinw1Description() {
        return mPinw1Description;
    }

    public boolean isForcedAir() {
        return mForcedAir;
    }

    public String getTemperatureLockPinHash() {
        return mTemperatureLockPinHash;
    }

    public boolean isAutoDehumEnabled() {
        return mAutoDehumEnabled;
    }

    public String getBackplateMonoInfo() {
        return mBackplateMonoInfo;
    }

    public String getStarType() {
        return mStarType;
    }

    public boolean isHasDualFuel() {
        return mHasDualFuel;
    }

    public double getMaintBandLower() {
        return mMaintBandLower;
    }

    public long getLearningTime() {
        return mLearningTime;
    }

    public long getCreationTime() {
        return mCreationTime;
    }

    public boolean isHasHumidifier() {
        return mHasHumidifier;
    }

    public int getLearningDaysCompletedRange() {
        return mLearningDaysCompletedRange;
    }

    public String getDehumidifierOrientationSelected() {
        return mDehumidifierOrientationSelected;
    }

    public double getLeafScheduleDelta() {
        return mLeafScheduleDelta;
    }

    public String getLoggingPriority() {
        return mLoggingPriority;
    }

    public String getUserBrighness() {
        return mUserBrighness;
    }

    public double getLeafAwayLow() {
        return mLeafAwayLow;
    }

    public String getPinRcDescription() {
        return mPinRcDescription;
    }

    public String getSerialNumber() {
        return mSerialNumber;
    }

    public boolean isAutoDehumState() {
        return mAutoDehumState;
    }

    public String getMacAddress() {
        return mMacAddress;
    }

    public String getHeatx2Source() {
        return mHeatx2Source;
    }

    public long getFanDutyStartTime() {
        return mFanDutyStartTime;
    }

    public long getTimeToTarget() {
        return mTimeToTarget;
    }

    public String getBackplateModel() {
        return mBackplateModel;
    }

    public String getModelVersion() {
        return mModelVersion;
    }

    public boolean isHeatPumpAuxThresholdEnabled() {
        return mHeatPumpAuxThresholdEnabled;
    }

    public boolean isObPersistence() {
        return mObPersistence;
    }
}
