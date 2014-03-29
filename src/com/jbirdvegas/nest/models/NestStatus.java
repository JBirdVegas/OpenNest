package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jbird on 3/16/14.
 */
public class NestStatus implements Serializable {
    @SerializedName("objects")
    private List<ValueObject> mNestObjects;

    public List<ValueObject> getNestObjects() {
        return mNestObjects;
    }

    public void setNestObjects(List<ValueObject> nestObjects) {
        mNestObjects = nestObjects;
    }
}