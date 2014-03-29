package com.jbirdvegas.nest.tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.helpers.FunctionHelper;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by jbird: 3/27/14
 */
public class SetAwayTask extends AsyncTask<Void, Void, Void> {
    private final NestHelper mHelper;
    private final String mName;
    private final boolean mIsChecked;

    public SetAwayTask(NestHelper helper, String name, boolean isChecked) {
        mHelper = helper;
        mName = name;
        mIsChecked = isChecked;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            List<ValueObject> sharedValueObjects = FunctionHelper.getSharedValueObjects(mHelper, mName);
            String objectKey = sharedValueObjects.get(0).getObjectKey();
            String deviceKey = objectKey.substring(objectKey.lastIndexOf("."));
            SharedValueObject sharedValueObject = FunctionHelper.setAway(mHelper, deviceKey, mIsChecked);
            Log.d("DEBUG_SHAREDVALUEOBJ", new Gson().toJson(sharedValueObject));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
