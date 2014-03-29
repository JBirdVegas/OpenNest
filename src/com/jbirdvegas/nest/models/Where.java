package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird: 3/16/14
 */
public class Where implements Serializable {
    @SerializedName("where_id")
    private String mWhereId;

    @SerializedName("name")
    private String mName;

    public String getWhereId() {
        return mWhereId;
    }

    public String getName() {
        return mName;
    }
}
