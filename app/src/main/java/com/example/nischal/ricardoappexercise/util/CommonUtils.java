package com.example.nischal.ricardoappexercise.util;

import android.app.Activity;
import android.provider.Settings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static Date getCurrentDate() {
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat displayDate = new SimpleDateFormat("dd MMM yyyy");
        String currentFormattedDate = displayDate.format(currentDate);
        Date currentReturnDate = null;
        try {
            currentReturnDate = displayDate.parse(currentFormattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return currentReturnDate;
    }

    //returns current system date in String
    public static String getCurrentDateString() {
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat displayDate = new SimpleDateFormat("dd MMM yyyy");
        String currentFormattedDate = displayDate.format(currentDate);
        return currentFormattedDate;
    }

    //get current date and time
    public static String getCurrentDateTimeString() {
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat displayDate = new SimpleDateFormat("dd MMM yyyy, HH:mm z");
        String currentFormattedDate = displayDate.format(currentDate);
        return currentFormattedDate;
    }

    public static String getCurrentDateToServer(Date date) {
        SimpleDateFormat serverDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");

        String serverDateString = serverDate.format(date);

        return serverDateString;
    }
}
