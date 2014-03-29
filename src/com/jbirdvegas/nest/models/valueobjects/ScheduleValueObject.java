package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.NestDays;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;

/**
 * Created by jbird on 3/16/14.
 */
public class ScheduleValueObject extends NestValue implements Serializable {
    @SerializedName("days")
    private NestDays mNestDays;

    @SerializedName("schedule_mode")
    private String mScheduleMode;

    @SerializedName("name")
    private String mName;

    @SerializedName("ver")
    private int mVer;

    public NestDays getNestDays() {
        return mNestDays;
    }

    public String getScheduleMode() {
        return mScheduleMode;
    }

    public String getName() {
        return mName;
    }

    public int getVer() {
        return mVer;
    }
}
