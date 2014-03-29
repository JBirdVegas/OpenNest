package com.jbirdvegas.nest.utils;

import com.google.gson.Gson;
import com.jbirdvegas.nest.models.NestStatus;
import com.jbirdvegas.nest.models.items.NestValue;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jbird: 3/17/14
 */
public class ValueObjectFinder {

    public List<ValueObject> findValueObjects(NestStatus nestStatus, Class valueObjectClass) {
        List<? extends ValueObject> list = nestStatus.getNestObjects();
        List<ValueObject> returnList = new ArrayList<ValueObject>(0);
        Iterator<? extends ValueObject> iterator = list.iterator();
        while (iterator.hasNext()) {
            ValueObject next = iterator.next();
            try {
                NestValue value = next.getNestValue();
                if (value.getClass().equals(valueObjectClass)) {
                    returnList.add(next);
                }
            } catch (NullPointerException e) {
                System.out.println("Failed to process: " + new Gson().toJson(next));
            }
        }
        return returnList;
    }

    public List<NestValue> findNestValueObjects(NestStatus nestStatus, Class valueObjectClass) {
        List<? extends ValueObject> list = nestStatus.getNestObjects();
        List<NestValue> returnList = new ArrayList<NestValue>(0);
        Iterator<? extends ValueObject> iterator = list.iterator();
        while (iterator.hasNext()) {
            ValueObject next = iterator.next();
            try {
                NestValue value = next.getNestValue();
                if (value.getClass().equals(valueObjectClass)) {
                    returnList.add(next.getNestValue());
                }
            } catch (NullPointerException e) {
                System.out.println("Failed to process: " + new Gson().toJson(next));
            }
        }
        return returnList;
    }
}