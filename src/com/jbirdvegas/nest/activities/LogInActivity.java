package com.jbirdvegas.nest.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.R;
import com.jbirdvegas.nest.constants.NestConstants;
import com.jbirdvegas.nest.services.NestService;
import com.kevinj.floatlabelpattern.FloatLabelTextView;

public class LogInActivity extends Activity {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private TextView mTitle;
    private FloatLabelTextView mEmail;
    private FloatLabelTextView mPassword;
    private Button mSubmitButton;
    private ProgressDialog mProgressDialog;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mTitle = (TextView) findViewById(R.id.main_menu_title);
        mEmail = (FloatLabelTextView) findViewById(R.id.user_email);
        mPassword = (FloatLabelTextView) findViewById(R.id.password);
        mPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        mSubmitButton = (Button) findViewById(R.id.submit);
        mSubmitButton.setOnClickListener(mRegister);

        checkForSavedCredentials();
    }

    private void checkForSavedCredentials() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString(NestConstants.USERNAME, null);
        String password = prefs.getString(NestConstants.PASSWORD, null);
        if (username != null) {
            mEmail.setText(username);
        }
        if (password != null) {
            mPassword.setText(password);
        }
        if (username != null && password != null) {
            performLogin();
        }
    }

    private BroadcastReceiver mLoginReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent responseIntent) {
            unregisterReceiver(mLoginReceiver);
            mProgressDialog.dismiss();
            NestHelper nestHelper = (NestHelper) responseIntent.getSerializableExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER);
            Intent client = new Intent(getApplicationContext(), NestClient.class);
            client.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            client.putExtra(NestConstants.INTENT_EXTRAS_NEST_HELPER, nestHelper);
            startActivity(client);
            finish();
        }
    };
    private View.OnClickListener mRegister = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            performLogin();
        }
    };

    private void performLogin() {
        mProgressDialog = ProgressDialog.show(this, getString(R.string.login_dialog_title), getString(R.string.login_dialog_message), true);
        String email = mEmail.getText();
        String pass = mPassword.getText();
        if (!"".equals(email) && !"".equals(pass)) {
            saveCredentials(email, pass);
            Intent loginIntent = new Intent(this, NestService.class);
            loginIntent.setAction(NestConstants.LOGIN);
            loginIntent.putExtra(NestConstants.USERNAME, email);
            loginIntent.putExtra(NestConstants.PASSWORD, pass);
            registerReceiver(mLoginReceiver, new IntentFilter(NestConstants.DELIVER_NEST_HELPER));
            startService(loginIntent);
        }
    }

    private void saveCredentials(String email, String pass) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putString(NestConstants.USERNAME, email);
        editor.putString(NestConstants.PASSWORD, pass);
        editor.commit();
    }
}