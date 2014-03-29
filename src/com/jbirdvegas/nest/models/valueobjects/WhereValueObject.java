package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.Where;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jbird: 3/16/14
 */
public class WhereValueObject extends NestValue implements Serializable {
    @SerializedName("wheres")
    private List<Where> mWheres;

    public List<Where> getWheres() {
        return mWheres;
    }
}
