package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.valueobjects.NestTempValues;

import java.io.Serializable;

/**
 * Created by jbird on 3/16/14.
 */
public class ChangeTempObject extends ChangeObject implements Serializable {
    @SerializedName("value")
    private NestTempValues mValues;

    public NestTempValues getValues() {
        return mValues;
    }

    public void setValues(NestTempValues values) {
        mValues = values;
    }
}