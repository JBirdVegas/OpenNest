package com.jbirdvegas.nest.views;

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
import com.jbirdvegas.nest.helpers.FunctionHelper;
import com.jbirdvegas.nest.models.ValueObjectListWrapper;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;
import com.jbirdvegas.nest.services.NestService;
import com.jbirdvegas.nest.utils.TempConversion;
import com.kevinj.floatlabelpattern.FloatLabelTextView;

import java.util.ArrayList;

/**
 * Created by jbird: 3/27/14
 */
public class NestDeviceView extends LinearLayout {
    private SharedValueObject mThermostat;
    private NestHelper mHelper;
    private TextView mDeviceName;
    private TextView mCurrentTemp;
    private Button mSetButton;
    private FloatLabelTextView mNewTemp;

    public NestDeviceView(Context context, NestHelper helper, final SharedValueObject thermostat) {
        super(context);
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
                Intent intent = new Intent(getContext(), NestService.class);
                intent.setAction(NestConstants.SET_TEMP);
                intent.putExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER, mHelper);
                intent.putExtra(NestConstants.NEW_TEMPERATURE, temp);
                ValueObjectListWrapper wrapper = new ValueObjectListWrapper((ArrayList<ValueObject>)
                        FunctionHelper.getSharedValueObjects(mHelper, thermostat.getName()));
                intent.putExtra(NestConstants.VALUE_OBJECTS_LIST, wrapper);
                getContext().startService(intent);
            }
        });

        setScreenValues();
    }

    public NestDeviceView updateDevice(NestHelper helper, SharedValueObject thermostat) {
        mHelper = helper;
        mThermostat = thermostat;
        setScreenValues();
        return this;
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