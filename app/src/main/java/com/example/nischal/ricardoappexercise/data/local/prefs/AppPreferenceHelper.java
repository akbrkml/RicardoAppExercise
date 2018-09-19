package com.example.nischal.ricardoappexercise.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nischal.ricardoappexercise.di.PreferenceInfo;
import com.example.nischal.ricardoappexercise.helper.AppConstants;

import javax.inject.Inject;

public class AppPreferenceHelper implements PreferencesHelper{

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    private static final String PREF_KEY_PHONE_NUMBER = "PREF_KEY_PHONE_NUMBER";
    private static final String PREF_KEY_PHONE_CODE = "PREF_KEY_PHONE_CODE";
    private static final String PREF_KEY_COUNTRY_CODE = "PREF_KEY_COUNTRY_CODE";
    private static final String PREF_KEY_COUNTRY_NAME = "PREF_KEY_COUNTRY_NAME";
    private static final String PREF_KEY_VERIFICATION_PAGE_OPEN = "PREF_KEY_VERIFICATION_PAGE";
    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL
            = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF_KEY_GROUP_ID = "PREF_KEY_GROUP_ID";
    private static final String PREF_KEY_BRAINTEE_ID = "PREF_KEY_BRAINTEE_ID";
    private static final String PREF_KEY_FARM_SETUP = "PREF_FARM_SETUP";
    private static final String PREF_KEY_LOGIN_FLAG = "PREF_LOGIN_FLAG";
    private static final String PREF_KEY_PAYMENT_FLAG = "PREF_KEY_PAYMENT_FLAG";
    private static final String PREF_KEY_REFRESH_TOKEN = "PREF_REFRESH_TOKEN";
    private static final String PREF_KEY_TIMESTAMP = "PREF_KEY_TIMESTAMP";
    private static final String PREF_KEY_PROFILE_IMAGE = "PREF_KEY_PROFILE_IMAGE";
    private static final String PREF_KEY_FARM_COUNT = "PREF_KEY_FARM_COUNT";
    private static final String PREF_FIREBASE_TOKEN = "PREF_FIREBASE_TOKEN";
    private static final String PREF_KEY_OWNER_SUBSCRIPTION = "PREF_KEY_OWNER_SUBSCRIPTION";
    private static final String PREF_KEY_PAYMENT_INFO = "PREF_KEY_PAYMENT_INFO";
    private static final String PREF_KEY_SUBSCRIBED = "PREF_KEY_SUBSCRIBED";
    private static final String PREF_KEY_SUBSCRIPTION_STATUS = "PREF_KEY_SUBSCRIPTION_STATUS";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferenceHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, context.MODE_PRIVATE);
    }



    @Override
    public void setLoginFlag(boolean login) {
        setKeyValue(PREF_KEY_LOGIN_FLAG, login);
    }

    @Override
    public boolean getLoginFlag() {
        return getBoolValues(PREF_KEY_LOGIN_FLAG);
    }


    @Override
    public String getAuthToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAuthToken(String authToken) {
        setKeyValue(PREF_KEY_ACCESS_TOKEN, authToken);
    }


    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        setKeyValue(PREF_KEY_CURRENT_USER_NAME, userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null);
    }

    @Override
    public void setCurrentUserEmail(String email) {
        setKeyValue(PREF_KEY_CURRENT_USER_EMAIL, email);
    }

    @Override
    public Integer getCurrentUserId() {
        Integer userId = mPrefs.getInt(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX? null: userId;
    }

    @Override
    public void setCurrentUserId(Integer userId) {
        userId = userId == null? AppConstants.NULL_INDEX: userId;
        setKeyValue(PREF_KEY_CURRENT_USER_ID, userId);
    }

    @Override
    public void setPaymentSetupInfo(String paymentHelp) {
        setKeyValue(PREF_KEY_PAYMENT_INFO, paymentHelp);
    }

    @Override
    public void setSubscribed(int subscribed) {
        setKeyValue(PREF_KEY_SUBSCRIBED, subscribed);
    }

    @Override
    public int getSubscriptionStatusPref() {
        return mPrefs.getInt(PREF_KEY_SUBSCRIPTION_STATUS, 0);
    }

    @Override
    public void setSubscriptionStatusPref(int status) {
        setKeyValue(PREF_KEY_SUBSCRIPTION_STATUS, status);
    }

    @Override
    public String getPhoneNumber() {
        return mPrefs.getString(PREF_KEY_PHONE_NUMBER, "");
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        setKeyValue(PREF_KEY_PHONE_NUMBER, phoneNumber);
    }

    @Override
    public String getPhoneCode() {
        return mPrefs.getString(PREF_KEY_PHONE_CODE, "");
    }


    @Override
    public void setPhoneCode(String code) {
        setKeyValue(PREF_KEY_PHONE_CODE, code);
    }

    @Override
    public void setGroupId(int id) {
        setKeyValue(PREF_KEY_GROUP_ID, id);
    }

    @Override
    public int getGroupId() {
        return mPrefs.getInt(PREF_KEY_GROUP_ID, 0);
    }

    @Override
    public String getCountryName() {
        return mPrefs.getString(PREF_KEY_COUNTRY_NAME, "");
    }

    @Override
    public void setCountryName(String name) {
        setKeyValue(PREF_KEY_COUNTRY_NAME, name);
    }

    @Override
    public void setFarmCount(Integer farmCount) {
        setKeyValue(PREF_KEY_FARM_COUNT, farmCount);
    }

    @Override
    public Integer getFarmCount() {
        return getIntValues(PREF_KEY_FARM_COUNT);
    }

    @Override
    public void setProfileImage(String profileImage) {
        setKeyValue(PREF_KEY_PROFILE_IMAGE, profileImage);
    }

    @Override
    public String getProfileImage() {
        return mPrefs.getString(PREF_KEY_PROFILE_IMAGE, "");
    }


    private void setKeyValue(String key, boolean value) {
        mPrefs.edit().putBoolean(key, value).apply();
    }

    private void setKeyValue(String key, String value) {
        mPrefs.edit().putString(key, value).apply();
    }

    private void setKeyValue(String key, Integer value) {
        mPrefs.edit().putInt(key, value).apply();
    }

    private boolean getBoolValues(String key) {
        boolean value = false;
        value = mPrefs.getBoolean(key, value);
        return value;
    }

    private int getIntValues(String key) {
        int nullValue = 0;
        int value = mPrefs.getInt(key, nullValue);
        return value;
    }
}
