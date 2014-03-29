package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.Payload;

import java.io.Serializable;

/**
 * Created by jbird on 3/16/14.
 */
public class NestTempValues extends Payload implements Serializable {
    @SerializedName("target_change_pending")
    private boolean mTargetChangePending;

    @SerializedName("touched_by")
    private TouchedByObject mTouchedBy;

    @SerializedName("target_temperature")
    private double mTargetTemp;

    public boolean isTargetChangePending() {
        return mTargetChangePending;
    }

    public void setTargetChangePending(boolean mTargetChangePending) {
        this.mTargetChangePending = mTargetChangePending;
    }

    public TouchedByObject getTouchedBy() {
        return mTouchedBy;
    }

    public void setTouchedBy(TouchedByObject mTouchedBy) {
        this.mTouchedBy = mTouchedBy;
    }

    public double getTargetTemp() {
        return mTargetTemp;
    }

    public void setTargetTemp(double mTargetTemp) {
        this.mTargetTemp = mTargetTemp;
    }
}