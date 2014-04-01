package com.jbirdvegas.nest.wearables;

import android.app.PendingIntent;
import android.content.Context;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.constants.NestConstants;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.utils.NestAndroidHelper;

/**
 * Created by jbird: 3/31/14
 */
public class WearableWrapper {
    private Context mContext;
    private final NestHelper mHelper;
    private final SharedValueObject mThermostat;
    private final int mIcon;
    private final String mTitle;
    private final int mCurrentTemp;
    private final PendingIntent mPendingIntent;

    public WearableWrapper(Context context, NestHelper helper, SharedValueObject thermostat,  int icon, String title, int temp ) {
        mContext = context;
        mHelper = helper;
        mThermostat = thermostat;
        mIcon = icon;
        mTitle = title;
        mCurrentTemp = temp;
        mPendingIntent = getTempIntent(temp);
    }

    private PendingIntent getTempIntent(int temp) {
        return PendingIntent.getService(mContext,
                NestConstants.WEARABLE_TEMP_CHANGE_REQUEST_CODE,
                NestAndroidHelper.getChangeTempIntent(mContext, temp, mHelper, mThermostat),
                0);
    }

    public int getIcon() {
        return mIcon;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getCurrentTemp() {
        return mCurrentTemp;
    }

    public PendingIntent getPendingIntent() {
        return mPendingIntent;
    }
}
