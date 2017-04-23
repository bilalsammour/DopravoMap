package com.dopravo.dopravomap.utils;


import com.google.gson.Gson;

public class JsonParser {

    private static Gson gson = new Gson();

    public static <T> T parseFromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static String parseToJson(Object src) {
        return gson.toJson(src);
    }
}
