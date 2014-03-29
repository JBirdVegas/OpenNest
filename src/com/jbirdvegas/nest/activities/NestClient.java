package com.jbirdvegas.nest.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.R;
import com.jbirdvegas.nest.constants.NestConstants;
import com.jbirdvegas.nest.helpers.FunctionHelper;
import com.jbirdvegas.nest.models.ValueObjectListWrapper;
import com.jbirdvegas.nest.models.items.NestValue;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.models.valueobjects.StructureValueObject;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;
import com.jbirdvegas.nest.services.NestService;
import com.jbirdvegas.nest.utils.ValueObjectFinder;
import com.jbirdvegas.nest.views.NestDeviceView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jbird: 3/21/14
 */
public class NestClient extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    private Switch mAwaySwitch;
    private NestHelper mNestHelper;
    private LinearLayout mDevicesLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private BroadcastReceiver mResponseReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            unregisterReceiver(mResponseReceiver);
            String errorMessage = intent.getStringExtra(NestConstants.ERROR);
            String action = intent.getAction();
            if (errorMessage == null) {
                switch (action) {
                    case NestConstants.DELIVER_NEST_HELPER:
                        mNestHelper = (NestHelper) intent.getSerializableExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER);
//                        addDevicesToScreen();
                        int childCount = mDevicesLayout.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            NestDeviceView deviceView = (NestDeviceView) mDevicesLayout.getChildAt(i);
                            List<NestValue> devices = FunctionHelper.getDeviceObjects(mNestHelper, deviceView.getDeviceName());
                            SharedValueObject deviceObject = (SharedValueObject) devices.get(0);
                            deviceView.updateDevice(mNestHelper, deviceObject);
                        }
                        break;
                    case NestConstants.DELIVER_SETTING_COMPLETE_RESPONSE:
                        // TODO: show new target temp somewhere
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        break;
                }
            } else {
                Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
            }
//            mSwipeRefreshLayout.setRefreshing(false);
        }
    };
    private BroadcastReceiver mIsWorkigReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mSwipeRefreshLayout.setRefreshing(intent.getBooleanExtra(NestConstants.IS_WORKING, false));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_main);
        mNestHelper = (NestHelper) getIntent().getSerializableExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER);
        mAwaySwitch = (Switch) findViewById(R.id.whole_home_away_switch);
        mDevicesLayout = (LinearLayout) findViewById(R.id.devices_layout);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        // TODO: These are the standard colors Google uses... maybe we should come up with a custom color schema
        mSwipeRefreshLayout.setColorScheme(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mAwaySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setAway(isChecked);
            }
        });
        addDevicesToScreen();
    }

    private void addDevicesToScreen() {
        List<NestValue> structureValueObjects = FunctionHelper.getStructureValueObjects(mNestHelper);
        mAwaySwitch.setChecked(((StructureValueObject) structureValueObjects.get(0)).isAway());
        List<NestValue> devices = FunctionHelper.getDeviceObjects(mNestHelper, null);
        for (java.util.Iterator iterator = devices.iterator(); iterator.hasNext(); ) {
            SharedValueObject thermostat = (SharedValueObject) iterator.next();
            mDevicesLayout.addView(new NestDeviceView(this, mNestHelper, thermostat));
        }
    }

    private void setAway(boolean away) {
        ValueObjectListWrapper wrapper = new ValueObjectListWrapper((ArrayList<ValueObject>) getDevices());
        Intent setAwayIntent = new Intent(this, NestService.class);
        setAwayIntent.setAction(NestConstants.SET_AWAY);
        setAwayIntent.putExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER, mNestHelper);
        setAwayIntent.putExtra(NestConstants.AWAY, away);
        setAwayIntent.putExtra(NestConstants.VALUE_OBJECTS_LIST, wrapper);
        startNestService(setAwayIntent);
    }

    private List<ValueObject> getDevices() {
        List<ValueObject> devices = new ValueObjectFinder().findValueObjects(mNestHelper.getNestStats(), StructureValueObject.class);
        List<ValueObject> room = new ArrayList<ValueObject>(0);
        for (ValueObject obj : devices) {
            // TODO add some smart selection of devices
            room.add(obj);
        }
        return room;
    }

    @Override
    public void onRefresh() {
        Intent refreshIntent = new Intent(this, NestService.class);
        refreshIntent.setAction(NestConstants.REFRESH);
        refreshIntent.putExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER, mNestHelper);
        startNestService(refreshIntent);
    }

    private void startNestService(Intent action) {
//        mSwipeRefreshLayout.setRefreshing(true);
        IntentFilter filter = new IntentFilter();
        filter.addAction(NestConstants.DELIVER_NEST_HELPER);
        filter.addAction(NestConstants.DELIVER_SETTING_COMPLETE_RESPONSE);
        registerReceiver(mResponseReceiver, filter);
        startService(action);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mIsWorkigReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mIsWorkigReceiver, new IntentFilter(NestConstants.IS_WORKING));
    }
}