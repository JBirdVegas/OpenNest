package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird: 3/16/14
 */
public class Structure implements Serializable {
    @SerializedName("structures")
    private String mStructure;

    public String getStructure() {
        return mStructure;
    }
}
