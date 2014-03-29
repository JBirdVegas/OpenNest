package com.jbirdvegas.nest.tasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.activities.NestClient;
import com.jbirdvegas.nest.constants.NestConstants;
import com.jbirdvegas.nest.exceptions.NestSetupIncompleteException;

/**
 * Created by jbird: 3/20/14
 */
public class RegisterNestTask extends AsyncTask<Pair<String, String>, Void, NestHelper> {
    private final Context mContext;

    public RegisterNestTask(Context context) {
        mContext = context;
    }

    @Override
    protected NestHelper doInBackground(Pair<String, String>... pairs) {
        try {
            return new NestHelper(pairs[0].first, pairs[0].second);
        } catch (NestSetupIncompleteException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(NestHelper nestHelper) {
        super.onPostExecute(nestHelper);
        if (nestHelper == null) {
            Log.wtf(this.getClass().getSimpleName(), "Return was null!");
        } else {
            Intent intent = new Intent(mContext, NestClient.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER, nestHelper);
            mContext.startActivity(intent);
        }
    }
}
