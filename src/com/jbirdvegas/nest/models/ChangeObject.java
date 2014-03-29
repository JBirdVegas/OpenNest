package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird: 3/19/14
 */
public class ChangeObject implements Serializable {
    @SerializedName("value")
    protected Payload mValue;

    @SerializedName("base_object_revision")
    protected long mBaseObjectRevision;

    @SerializedName("op")
    protected String mOp;

    @SerializedName("object_key")
    protected String mObjectKey;

    public Payload getValue() {
        return mValue;
    }

    public void setValue(Payload mValue) {
        this.mValue = mValue;
    }

    public long getBaseObjectRevision() {
        return mBaseObjectRevision;
    }

    public void setBaseObjectRevision(long mBaseObjectRevision) {
        this.mBaseObjectRevision = mBaseObjectRevision;
    }

    public String getOp() {
        return mOp;
    }

    public void setOp(String mOp) {
        this.mOp = mOp;
    }

    public String getObjectKey() {
        return mObjectKey;
    }

    public void setObjectKey(String mObjectKey) {
        this.mObjectKey = mObjectKey;
    }
}
