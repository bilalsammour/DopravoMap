package com.dopravo.dopravomap.utils;


import com.google.gson.Gson;

@SuppressWarnings("unused")
public class JsonParser {

    private static final Gson gson = new Gson();

    public static <T> T parseFromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static String parseToJson(Object src) {
        return gson.toJson(src);
    }
}
