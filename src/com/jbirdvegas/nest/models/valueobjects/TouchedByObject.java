package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird on 3/16/14.
 */
public class TouchedByObject implements Serializable {
    @SerializedName("touched_by")
    private int mTouchedBy;

    public TouchedByObject(int touchedBy) {
        mTouchedBy = touchedBy;
    }

    public int getTouchedBy() {
        return mTouchedBy;
    }
}
