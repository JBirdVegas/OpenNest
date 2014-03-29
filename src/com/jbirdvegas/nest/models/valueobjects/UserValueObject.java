package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.Structure;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;

/**
 * Created by jbird: 3/16/14
 */
public class UserValueObject extends NestValue implements Serializable {
    @SerializedName("email")
    private String mEmail;

    @SerializedName("name")
    private String mName;

    @SerializedName("structures")
    private Structure[] mStructures;

    public String getEmail() {
        return mEmail;
    }

    public String getName() {
        return mName;
    }

    public Structure[] getStructures() {
        return mStructures;
    }
}
