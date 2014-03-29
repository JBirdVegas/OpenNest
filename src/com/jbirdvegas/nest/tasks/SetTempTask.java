package com.jbirdvegas.nest.tasks;

import android.os.AsyncTask;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.helpers.FunctionHelper;

import java.io.IOException;

/**
 * Created by jbird: 3/27/14
 */
public class SetTempTask extends AsyncTask<Void, Void, Void> {
    private final NestHelper mHelper;
    private final String mName;
    private final int mTemp;

    public SetTempTask(NestHelper helper, String name, int temp) {
        mHelper = helper;
        mName = name;
        mTemp = temp;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            FunctionHelper.setNewTemp(mHelper, mName, mTemp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
