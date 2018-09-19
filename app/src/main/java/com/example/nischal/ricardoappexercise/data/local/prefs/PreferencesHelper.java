package com.example.nischal.ricardoappexercise.data.local.prefs;

public interface PreferencesHelper {

    void setLoginFlag(boolean login);

    boolean getLoginFlag();

    String getAuthToken();

    void setAuthToken(String authToken);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    Integer getCurrentUserId();

    void setCurrentUserId(Integer userId);

    void setPaymentSetupInfo(String paymentHelp);

    void setSubscribed(int subscribed);

    int getSubscriptionStatusPref();

    void setSubscriptionStatusPref(int status);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getPhoneCode();

    void setPhoneCode(String code);

    void setGroupId(int id);

    int getGroupId();

    String getCountryName();

    void setCountryName(String name);

    void setFarmCount(Integer farmCount);

    Integer getFarmCount();

    void setProfileImage(String profileImage);

    String getProfileImage();
    //////////========================================================

    //todo
}
