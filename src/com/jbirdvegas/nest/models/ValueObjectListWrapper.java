package com.jbirdvegas.nest.models;

import com.jbirdvegas.nest.models.valueobjects.ValueObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jbird: 3/29/14
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
