package com.jbirdvegas.nest.helpers;

import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.models.items.NestValue;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.models.valueobjects.StructureValueObject;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;
import com.jbirdvegas.nest.utils.ValueObjectFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jbird: 3/27/14
 */
public class FunctionHelper {
    public static SharedValueObject setNewTemp(NestHelper helper, String deviceName, int temp) throws IOException {
        List<ValueObject> room = getSharedValueObjects(helper, deviceName);
        return helper.setNewTemp(helper.getSession(), room, temp);
    }

    public static SharedValueObject setAway(NestHelper helper, String deviceName, boolean away) throws IOException {
        List<ValueObject> devices = new ValueObjectFinder().findValueObjects(helper.getNestStats(), StructureValueObject.class);
        List<ValueObject> room = new ArrayList<ValueObject>(0);
        for (ValueObject obj : devices) {
//            if (deviceName != null) {
                // TODO add some smart selection of devices
//                if (((StructureValueObject) obj.getNestValue()).getName().equals(deviceName)) {
                   room.add(obj);
//                }
//            } else {
//                room.add(obj);
//            }
        }
        return helper.setAway(helper.getSession(), room, away);
    }

    public static List<ValueObject> getSharedValueObjects(NestHelper helper, String deviceName) {
        List<ValueObject> devices = new ValueObjectFinder().findValueObjects(helper.getNestStats(), SharedValueObject.class);
        List<ValueObject> room = new ArrayList<ValueObject>(0);
        for (ValueObject obj : devices) {
            if (deviceName != null) {
                if (((SharedValueObject) obj.getNestValue()).getName().equals(deviceName)) {
                    room.add(obj);
                }
            } else {
                room.add(obj);
            }
        }
        return room;
    }

    public static List<NestValue> getNestValueObjects(NestHelper helper, String deviceName, Class clazz) {
        List<NestValue> devices = new ValueObjectFinder().findNestValueObjects(helper.getNestStats(), clazz);
        List<NestValue> room = new ArrayList<NestValue>(0);
        for (NestValue obj : devices) {
            if (deviceName != null) {
                if (((SharedValueObject) obj).getName().equals(deviceName)) {
                    room.add(obj);
                }
            } else {
                room.add(obj);
            }
        }
        return room;
    }

    public static List<NestValue> getDeviceObjects(NestHelper helper, String deviceName) {
        List<NestValue> devices = new ValueObjectFinder().findNestValueObjects(helper.getNestStats(), SharedValueObject.class);
        List<NestValue> room = new ArrayList<NestValue>(0);
        for (NestValue obj : devices) {
            if (deviceName != null) {
                if (((SharedValueObject) obj).getName().equals(deviceName)) {
                    room.add(obj);
                }
            } else {
                room.add(obj);
            }
        }
        return room;
    }

    public static List<NestValue> getStructureValueObjects(NestHelper helper) {
        List<NestValue> devices = new ValueObjectFinder().findNestValueObjects(helper.getNestStats(), StructureValueObject.class);
        List<NestValue> room = new ArrayList<NestValue>(0);
        for (NestValue obj : devices) {
            room.add(obj);
        }
        return room;
    }
}
