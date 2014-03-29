package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * Created by jbird: 3/16/14
 */
public class TrackValueObject extends MetadataValueObject implements Serializable {
    @SerializedName("online")
    private boolean mOnline;

    public boolean isOnline() {
        return mOnline;
    }
}