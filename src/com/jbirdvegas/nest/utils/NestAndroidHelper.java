package com.jbirdvegas.nest.utils;

import android.content.Context;
import android.content.Intent;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.constants.NestConstants;
import com.jbirdvegas.nest.helpers.FunctionHelper;
import com.jbirdvegas.nest.models.ValueObjectListWrapper;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;
import com.jbirdvegas.nest.services.NestService;

import java.util.ArrayList;

/**
 * Created by jbird: 4/1/14
 */
public class NestAndroidHelper {

    public static Intent getChangeTempIntent(Context context, int newTemp, NestHelper helper, SharedValueObject thermostat) {
        Intent intent = new Intent(context, NestService.class);
        intent.setAction(NestConstants.SET_TEMP);
        intent.putExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER, helper);
        intent.putExtra(NestConstants.NEW_TEMPERATURE, newTemp);
        ValueObjectListWrapper wrapper = new ValueObjectListWrapper((ArrayList<ValueObject>)
                FunctionHelper.getSharedValueObjects(helper, thermostat.getName()));
        intent.putExtra(NestConstants.VALUE_OBJECTS_LIST, wrapper);
        return intent;
    }
}
