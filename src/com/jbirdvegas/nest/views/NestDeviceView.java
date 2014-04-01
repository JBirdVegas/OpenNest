package com.jbirdvegas.nest.views;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.R;
import com.jbirdvegas.nest.constants.NestConstants;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.utils.NestAndroidHelper;
import com.jbirdvegas.nest.utils.TempConversion;
import com.kevinj.floatlabelpattern.FloatLabelTextView;
import com.wearables.WearableHelper;

/**
 * Created by jbird: 3/27/14
 */
public class NestDeviceView extends LinearLayout {
    private Context mContext;
    private SharedValueObject mThermostat;
    private NestHelper mHelper;
    private TextView mDeviceName;
    private TextView mCurrentTemp;
    private Button mSetButton;
    private FloatLabelTextView mNewTemp;

    public NestDeviceView(final Context context, final NestHelper helper, final SharedValueObject thermostat) {
        super(context);
        mContext = context;
        mThermostat = thermostat;
        mHelper = helper;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.nest_thermostat_controler, this, true);
        init();
        mNewTemp.setInputType(InputType.TYPE_CLASS_NUMBER);
        mSetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(mNewTemp.getText());
                Intent intent = NestAndroidHelper.getChangeTempIntent(context, temp, helper, thermostat);
                getContext().startService(intent);
            }
        });
        setScreenValues();
        updateWearables();
    }

    public NestDeviceView updateDevice(Context context, NestHelper helper, SharedValueObject thermostat) {
        mContext = context;
        mHelper = helper;
        mThermostat = thermostat;
        setScreenValues();
        updateWearables();
        return this;
    }

    private void updateWearables() {
        Notification setAbleTemperatureActions = WearableHelper.getSetAbleTemperatureActions(mContext,
                mHelper,
                mThermostat,
                (int) mThermostat.getCurrentTemp());
        NotificationManager manager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NestConstants.WEARABLE_TEMP_CHANGE_REQUEST_CODE, setAbleTemperatureActions);
    }

    public String getDeviceName() {
        return mThermostat.getName();
    }

    private void setScreenValues() {
        mDeviceName.setText(mThermostat.getName());
        double currentTemp = mThermostat.getCurrentTemp();
        mCurrentTemp.setText(getTemperatureText(currentTemp));
    }

    private String getTemperatureText(double currentTemp) {
        String fahrenheit = String.valueOf(TempConversion.getFahrenheit(currentTemp));
        return fahrenheit + " \u00B0 F";
    }

    private void init() {
        mDeviceName = (TextView) findViewById(R.id.thermostat_name);
        mCurrentTemp = (TextView) findViewById(R.id.current_temp);
        mNewTemp = (FloatLabelTextView) findViewById(R.id.new_temperature);
        mSetButton = (Button) findViewById(R.id.device_set_temp_button);
    }
}