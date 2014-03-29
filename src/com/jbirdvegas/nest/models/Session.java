package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird on 3/14/14.
 */
public class Session implements Serializable {
    @SerializedName("userid")
    private String mUserId;

    @SerializedName("user")
    private String mUser;

    @SerializedName("access_token")
    private String mAccessToken;

    // Token expiration typically ~48 hours
    @SerializedName("expires_in")
    private String mExpiration;

    @SerializedName("language")
    private String mLanguage;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("is_superuser")
    private boolean mIsSuperuser;

    @SerializedName("is_staff")
    private boolean mIsStaff;

    @SerializedName("urls")
    private Urls mUrls;

    @SerializedName("limits")
    private Limits mLimits;

    @SerializedName("weave")
    private Weave mWeave;

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String user) {
        mUser = user;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }

    public String getExpiration() {
        return mExpiration;
    }

    public void setExpiration(String expiration) {
        mExpiration = expiration;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public boolean isSuperuser() {
        return mIsSuperuser;
    }

    public void setSuperuser(boolean isSuperuser) {
        mIsSuperuser = isSuperuser;
    }

    public boolean isStaff() {
        return mIsStaff;
    }

    public void setStaff(boolean isStaff) {
        mIsStaff = isStaff;
    }

    public Urls getUrls() {
        return mUrls;
    }

    public void setUrls(Urls urls) {
        mUrls = urls;
    }

    public Limits getLimits() {
        return mLimits;
    }

    public void setLimits(Limits limits) {
        mLimits = limits;
    }

    public Weave getWeave() {
        return mWeave;
    }

    public void setWeave(Weave weave) {
        mWeave = weave;
    }
}