package com.jbirdvegas.nest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jbird on 3/16/14.
 */
public class TempPayload implements Serializable {
//    private List<NestSimpleObject> mObjects;
    @SerializedName("session")
    private String mSession;

    @SerializedName("objects")
    private List<? extends ChangeObject> mObjects;

    public String getSession() {
        return mSession;
    }

    public void setSession(String session) {
        mSession = session;
    }

    public List<? extends ChangeObject> getObjects() {
        return mObjects;
    }

    public void setObjects(List<? extends ChangeObject> objects) {
        mObjects = objects;
    }
}
