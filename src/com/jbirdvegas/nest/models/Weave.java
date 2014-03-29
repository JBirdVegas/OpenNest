package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird on 3/14/14.
 */
public class Weave implements Serializable {
    @SerializedName("service_config")
    private String mServiceConfig;

    @SerializedName("pairing_token")
    private String mPairingToken;

    @SerializedName("access_token")
    private String mAccessToken;

    public String getPairingToken() {
        return mPairingToken;
    }

    public String getServiceConfig() {
        return mServiceConfig;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

}
