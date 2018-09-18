package com.example.nischal.ricardoappexercise.util;

import android.app.Activity;
import android.provider.Settings;

public class CommonUtils {

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    /**
     * Method to get the device id
     *
     * @param activity
     */
    public static String getDeviceId(Activity activity) {
        return Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}
