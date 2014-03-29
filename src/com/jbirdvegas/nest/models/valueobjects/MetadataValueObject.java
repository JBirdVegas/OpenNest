package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;

/**
 * Created by jbird: 3/16/14
 */
public class MetadataValueObject extends NestValue implements Serializable {
    @SerializedName("last_ip")
    private String mLastIp;

    @SerializedName("last_connection")
    private long mLastConnection;

    public String getLastIp() {
        return mLastIp;
    }

    public long getLastConnection() {
        return mLastConnection;
    }
}
