package com.jbirdvegas.nest.services;

import android.app.IntentService;
import android.content.Intent;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.R;
import com.jbirdvegas.nest.constants.NestConstants;
import com.jbirdvegas.nest.exceptions.NestSetupIncompleteException;
import com.jbirdvegas.nest.models.ValueObjectListWrapper;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;

import java.io.IOException;

/**
 * Created by jbird: 3/29/14
 */
public class NestService extends IntentService {
    public NestService() {
        super(NestService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        NestHelper helper = (NestHelper) intent.getSerializableExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER);
        ValueObjectListWrapper wrapper = (ValueObjectListWrapper) intent.getSerializableExtra(NestConstants.VALUE_OBJECTS_LIST);
        showWorking(true);

        switch (action) {
            case NestConstants.LOGIN:
                String username = intent.getStringExtra(NestConstants.USERNAME);
                String password = intent.getStringExtra(NestConstants.PASSWORD);
                try {
                    NestHelper helper1 = new NestHelper(username, password);
                    sendNestHelperResponse(helper1);
                } catch (NestSetupIncompleteException e) {
                    sendNestHelperResponse(null);
                }
                break;
            case NestConstants.REFRESH:
                if (helper != null) {
                    try {
                        sendNestHelperResponse(helper.refresh());
                    } catch (IOException | NestSetupIncompleteException e) {
                        sendNestHelperResponse(null);
                    }
                }
                break;
            case NestConstants.SET_TEMP:
                int temp = intent.getIntExtra(NestConstants.NEW_TEMPERATURE, -1);
                try {
                    if (helper != null && wrapper != null) {
                        SharedValueObject sharedValueObject = helper.setNewTemp(helper.getSession(), wrapper.getValueObjects(), temp);
                        sendSetCompleteResponse(sharedValueObject, null);
                    }
                } catch (IOException e) {
                    sendSetCompleteResponse(null, getString(R.string.failed_to_set_temp));
                }
                break;
            case NestConstants.SET_AWAY:
                boolean away = intent.getBooleanExtra(NestConstants.AWAY, false);
                try {
                    if (helper != null && wrapper != null) {
                        SharedValueObject sharedValueObject = helper.setAway(helper.getSession(), wrapper.getValueObjects(), away);
                        sendSetCompleteResponse(sharedValueObject, null);
                    }
                } catch (IOException e) {
                    sendSetCompleteResponse(null, getString(R.string.failed_to_set_away));
                }
                break;
        }
        showWorking(false);
        stopSelf();
    }

    private void showWorking(boolean isWorking) {
        Intent showWorking = new Intent(NestConstants.IS_WORKING);
        showWorking.putExtra(NestConstants.IS_WORKING, isWorking);
        sendBroadcast(showWorking);
    }

    private void sendSetCompleteResponse(SharedValueObject sharedValueObject, String errorMessage) {
        Intent response = new Intent(NestConstants.DELIVER_SETTING_COMPLETE_RESPONSE);
        if (sharedValueObject == null) {
            response.putExtra(NestConstants.ERROR, errorMessage);
        } else {
            response.putExtra(NestConstants.SHARED_VALUE_OBJECT, sharedValueObject);
        }
        getApplicationContext().sendBroadcast(response);
    }

    private void sendNestHelperResponse(NestHelper helper) {
        Intent response = new Intent(NestConstants.DELIVER_NEST_HELPER);
        if (helper == null) {
            response.putExtra(NestConstants.ERROR, getString(R.string.login_failed));
        } else {
            response.putExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER, helper);
        }
        getApplicationContext().sendBroadcast(response);
    }
}