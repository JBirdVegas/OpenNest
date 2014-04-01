package com.jbirdvegas.nest.models;

import com.jbirdvegas.nest.models.valueobjects.ValueObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is a wrapper that allows passing a List of custom objects through
 * through an intent bundle.
 */
public class ValueObjectListWrapper implements Serializable {
    private ArrayList<ValueObject> mValueObjects = new ArrayList<>(0);

    public ValueObjectListWrapper(ArrayList<ValueObject> list) {
        mValueObjects = list;
    }

    public ArrayList<ValueObject> getValueObjects() {
        return mValueObjects;
    }
}
