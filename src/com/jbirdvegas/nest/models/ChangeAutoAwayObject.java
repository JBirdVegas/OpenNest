package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.payloads.NestAutoAwayValues;

import java.io.Serializable;

/**
 * Created by jbird: 3/19/14
 */
public class ChangeAutoAwayObject extends ChangeObject implements Serializable {
    @SerializedName("value")
    private NestAutoAwayValues mValues;

    public NestAutoAwayValues getValues() {
        return mValues;
    }

    public void setValues(NestAutoAwayValues values) {
        mValues = values;
    }
}
