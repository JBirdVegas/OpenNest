package com.jbirdvegas.nest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jbirdvegas.nest.deserializers.NestStatusDeserializer;
import com.jbirdvegas.nest.models.NestStatus;
import com.jbirdvegas.nest.models.valueobjects.ValueObject;

/**
 * Created by jbird: 3/17/14
 */
public class NestStatusHelper {
    public static NestStatus generateNestStatus(String jsonResults) {
        NestStatusDeserializer deserializer = new NestStatusDeserializer();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ValueObject.class, deserializer);
        Gson gson = builder.create();
        NestStatus nestStatus = gson.fromJson(jsonResults, NestStatus.class);
        return nestStatus;
    }
}
