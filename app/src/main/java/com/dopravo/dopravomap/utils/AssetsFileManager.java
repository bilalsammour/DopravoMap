package com.dopravo.dopravomap.utils;


import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class AssetsFileManager {

    public static String readFile
            (Context context, String fullName) throws IOException {

        InputStream inputStream = context
                .getAssets()
                .open(fullName);
        int size = inputStream.available();
        byte[] buffer = new byte[size];

        //noinspection ResultOfMethodCallIgnored
        inputStream.read(buffer);

        return new String(buffer);
    }

}
