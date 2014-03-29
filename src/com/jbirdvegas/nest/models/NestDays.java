package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jbird on 3/16/14.
 */
public class NestDays implements Serializable {
    @SerializedName("0")
    private ScheduledDay mZeroDay;

    @SerializedName("1")
    private ScheduledDay mDayOne;

    @SerializedName("2")
    private ScheduledDay mDayTwo;

    @SerializedName("3")
    private ScheduledDay mDayThree;

    @SerializedName("4")
    private ScheduledDay mDayFour;

    @SerializedName("5")
    private ScheduledDay mDayFive;

    @SerializedName("6")
    private ScheduledDay mDaySix;

    public List<ScheduledDay> getScheduledWeek() {
        ArrayList<ScheduledDay> scheduledDays = new ArrayList<ScheduledDay>();
        scheduledDays.add(mZeroDay);
        scheduledDays.add(mDayOne);
        scheduledDays.add(mDayTwo);
        scheduledDays.add(mDayThree);
        scheduledDays.add(mDayFour);
        scheduledDays.add(mDayFive);
        scheduledDays.add(mDaySix);
        return scheduledDays;
    }
}
