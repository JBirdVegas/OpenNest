package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird on 3/14/14.
 */
public class Urls implements Serializable {
    @SerializedName("transport_url")
    private String mTransportUrl;

    @SerializedName("rubyapi_url")
    private String mRubyApiUrl;

    @SerializedName("weather_url")
    private String mWeaterUrl;

    @SerializedName("log_upload_url")
    private String mLogUploadUrl;

    @SerializedName("support_url")
    private String mSupportUrl;

    public String getTransportUrl() {
        return mTransportUrl;
    }

    public String getRubyApiUrl() {
        return mRubyApiUrl;
    }

    public String getWeaterUrl() {
        return mWeaterUrl;
    }

    public String getSupportUrl() {
        return mSupportUrl;
    }

    public String getLogUploadUrl() {
        return mLogUploadUrl;
    }
}