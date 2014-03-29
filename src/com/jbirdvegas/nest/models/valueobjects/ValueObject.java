package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;

/**
 * Created by jbird: 3/16/14
 */
public class ValueObject implements Serializable {
    @SerializedName("object_revision")
    private long mObjectRevision;

    @SerializedName("object_timestamp")
    private long mObjectTimestamp;

    @SerializedName("object_key")
    private String mObjectKey;

    @SerializedName("value")
    private NestValue mNestValue;

    public long getObjectRevision() {
        return mObjectRevision;
    }

    public long getObjectTimestamp() {
        return mObjectTimestamp;
    }

    public String getObjectKey() {
        return mObjectKey;
    }

    public NestValue getNestValue() {
        return mNestValue;
    }

    public void setNestValue(NestValue value) {
        mNestValue = value;
    }
}