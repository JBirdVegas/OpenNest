package com.jbirdvegas.nest.payloads;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.Payload;
import com.jbirdvegas.nest.models.valueobjects.TouchedByObject;

import java.io.Serializable;

/**
 * Created by jbird: 3/19/14
 */
public class NestAutoAwayValues extends Payload implements Serializable {
    @SerializedName("away")
    private boolean mIsAway;
    @SerializedName("touched_by")
    private TouchedByObject mTouchedByObject;
    @SerializedName("away_setter")
    private int mAwaySetter;

    public boolean isAway() {
        return mIsAway;
    }

    public TouchedByObject getTouchedByObject() {
        return mTouchedByObject;
    }

    public int getAwaySetter() {
        return mAwaySetter;
    }

    public void setAway(boolean isAway) {
        mIsAway = isAway;
    }

    public void setTouchedByObject(TouchedByObject touchedByObject) {
        mTouchedByObject = touchedByObject;
    }

    public void setAwaySetter(int awaySetter) {
        mAwaySetter = awaySetter;
    }
}
