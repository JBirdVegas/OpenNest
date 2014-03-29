package com.jbirdvegas.nest.models.valueobjects;

import com.google.gson.annotations.SerializedName;
import com.jbirdvegas.nest.models.items.NestValue;

import java.io.Serializable;

/**
 * Created by jbird: 3/16/14
 */
public class NestAlertDialog extends NestValue implements Serializable {
    @SerializedName("dialog_data")
    private String mDialogData;

    // example: confirm-pairing
    @SerializedName("dialog_id")
    private String mDialogId;

    public String getDialogData() {
        return mDialogData;
    }

    public String getDialogId() {
        return mDialogId;
    }
}
