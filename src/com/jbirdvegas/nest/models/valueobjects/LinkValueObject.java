package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;

/**
 * Created by jbird on 3/16/14.
 */
public class LinkValueObject extends NestValue implements Serializable {
    @SerializedName("structure")
    private String mStructure;

    public String getStructure() {
        return mStructure;
    }
}
