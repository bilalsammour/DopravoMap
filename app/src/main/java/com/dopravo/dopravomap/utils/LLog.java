package com.dopravo.dopravomap.utils;


import android.util.Log;

@SuppressWarnings("unused")
public class LLog {

    private static final String TAG = "LLog";

    public static void d(String message) {
        Log.d(TAG, message);
    }

    public static void i(String message) {
        Log.i(TAG, message);
    }

    public static void e(String message) {
        Log.e(TAG, message);
    }
}
