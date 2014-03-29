package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jbird on 3/16/14.
 */
public class LogInPayload implements Serializable {
    @SerializedName("password")
    private String mPassword;

    @SerializedName("email")
    private String mEmail;

    public LogInPayload(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}