package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jbird: 3/16/14
 */
public class MessageCenterValueObject extends NestValue implements Serializable {
    @SerializedName("messages")
    private List<? extends MessageValueObject> mMessages;

    public List<? extends MessageValueObject> getMessages() {
        return mMessages;
    }
}
