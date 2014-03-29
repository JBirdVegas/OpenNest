package com.jbirdvegas.nest;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.jbirdvegas.nest.models.items.NestValue;
import com.jbirdvegas.nest.models.valueobjects.DemandResponseValueObject;
import com.jbirdvegas.nest.models.valueobjects.DeviceAlertDialogValueObject;
import com.jbirdvegas.nest.models.valueobjects.DeviceValueObject;
import com.jbirdvegas.nest.models.valueobjects.LinkValueObject;
import com.jbirdvegas.nest.models.valueobjects.MessageCenterValueObject;
import com.jbirdvegas.nest.models.valueobjects.MessageValueObject;
import com.jbirdvegas.nest.models.valueobjects.MetadataValueObject;
import com.jbirdvegas.nest.models.valueobjects.NestAlertDialog;
import com.jbirdvegas.nest.models.valueobjects.ScheduleValueObject;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.models.valueobjects.StructureValueObject;
import com.jbirdvegas.nest.models.valueobjects.TrackValueObject;
import com.jbirdvegas.nest.models.valueobjects.TuneUpsValueObject;
import com.jbirdvegas.nest.models.valueobjects.UserSettingsValueObject;
import com.jbirdvegas.nest.models.valueobjects.UtilityValueObject;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;
import com.jbirdvegas.nest.models.valueobjects.WhereValueObject;

import java.lang.reflect.Type;

/**
 * Created by jbird: 3/17/14
 */
public class NestStatusDeserializer implements JsonDeserializer<ValueObject> {
    private static final String DEMAND_RESPONSE = "demand_response.";
    private static final String SHARED = "shared.";
    private static final String LINK = "link.";
    private static final String DEVICE_ALERT_DIALOG = "device_alert_dialog.";
    private static final String SCHEDULE = "schedule.";
    private static final String WHERE = "where.";
    private static final String MESSAGE = "message.";
    private static final String UTILITY = "utility.";
    private static final String DEVICE = "device.";
    private static final String USER = "user.";
    private static final String STRUCTURE = "structure.";
    private static final String TUNEUPS = "tuneups.";
    private static final String METADATA = "metadata.";
    private static final String MESSAGE_CENTER = "message_center.";
    private static final String USER_SETTINGS = "user_settings.";
    private static final String TRACK = "track.";
    private static final String USER_ALERT_DIALOG = "user_alert_dialog.";

    @Override
    public ValueObject deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        ValueObject valueObject = new Gson().fromJson(jsonElement, ValueObject.class);
        try {
            JsonObject value = jsonObject.get("value").getAsJsonObject();
            if (value.isJsonObject()) {
                NestValue nestValue = findValueObject(value, valueObject.getObjectKey());
                valueObject.setNestValue(nestValue);
                return valueObject;
            } else
                System.out.println("value was an array: " + value.toString());
        } catch (JsonParseException e) {
            System.out.println("Failed to handle: " + jsonElement.toString());
            e.printStackTrace();
        }
        return null;
    }

    public static NestValue findValueObject(JsonObject jsonObject, String objectKey) throws JsonParseException {

        Gson gson = new Gson();
        if (objectKey == null) {
            // TODO: Too generic?
            return gson.fromJson(jsonObject, NestAlertDialog.class);
        }

        if (objectKey.startsWith(DEMAND_RESPONSE)) {
            return gson.fromJson(jsonObject, DemandResponseValueObject.class);
        } else if (objectKey.startsWith(SHARED)) {
//            return gson.fromJson(jsonObject, SharedValueObject.class);
            return gson.fromJson(jsonObject, SharedValueObject.class);
        } else if (objectKey.startsWith(LINK)) {
            return gson.fromJson(jsonObject, LinkValueObject.class);
        } else if (objectKey.startsWith(DEVICE_ALERT_DIALOG)) {
            return gson.fromJson(jsonObject, DeviceAlertDialogValueObject.class);
        } else if (objectKey.startsWith(SCHEDULE)) {
            return gson.fromJson(jsonObject, ScheduleValueObject.class);
        } else if (objectKey.startsWith(WHERE)) {
            return gson.fromJson(jsonObject, WhereValueObject.class);
        } else if (objectKey.startsWith(MESSAGE)) {
            return gson.fromJson(jsonObject, MessageValueObject.class);
        } else if (objectKey.startsWith(UTILITY)) {
            return gson.fromJson(jsonObject, UtilityValueObject.class);
        } else if (objectKey.startsWith(DEVICE)) {
            return gson.fromJson(jsonObject, DeviceValueObject.class);
        } else if (objectKey.startsWith(USER)) {
            // TODO IllegalStateException: Expected BEGIN_ARRAY but was STRING
            Type clazzListType = new TypeToken<NestValue>(){}.getType();
            return gson.fromJson(jsonObject, clazzListType);
        } else if (objectKey.startsWith(STRUCTURE)) {
            return gson.fromJson(jsonObject, StructureValueObject.class);
        } else if (objectKey.startsWith(TUNEUPS)) {
            return gson.fromJson(jsonObject, TuneUpsValueObject.class);
        } else if (objectKey.startsWith(METADATA)) {
            return gson.fromJson(jsonObject, MetadataValueObject.class);
        } else if (objectKey.startsWith(MESSAGE_CENTER)) {
            return gson.fromJson(jsonObject, MessageCenterValueObject.class);
        } else if (objectKey.startsWith(USER_SETTINGS)) {
            return gson.fromJson(jsonObject, UserSettingsValueObject.class);
        } else if (objectKey.startsWith(TRACK)) {
            return gson.fromJson(jsonObject, TrackValueObject.class);
        } else if (objectKey.startsWith(USER_ALERT_DIALOG)) {
            return gson.fromJson(jsonObject, NestAlertDialog.class);
        }
        throw new JsonParseException("Failed to handle: " + objectKey);
    }
}