package com.example.nischal.ricardoappexercise.data;

import android.content.Context;

import com.example.nischal.ricardoappexercise.data.local.db.DbHelper;
import com.example.nischal.ricardoappexercise.data.local.prefs.PreferencesHelper;
import com.example.nischal.ricardoappexercise.data.remote.ApiServices;
import com.example.nischal.ricardoappexercise.ui.login.model.LoginRequest;
import com.example.nischal.ricardoappexercise.ui.login.model.LoginResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;

@Singleton
public class AppDataManager implements DataManager{

    private final Context context;
    private final DbHelper dbHelper;
    private final ApiServices apiServices;
    private final PreferencesHelper preferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, ApiServices apiServices, PreferencesHelper preferencesHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.apiServices = apiServices;
        this.preferencesHelper = preferencesHelper;
    }

    // =================== api =====================================================

    @Override
    public Observable<LoginResponse> loginRequest(LoginRequest loginRequest) {
        return apiServices.loginRequest(loginRequest);
    }

    @Override
    public Observable<Response<LoginResponse>> login(LoginRequest loginRequest) {
        return apiServices.login(loginRequest);
    }
    //====================== api =====================================================

    //========================== local db =========================================
    @Override
    public void addUsers(LoginResponse.Data loginResponse) {
        dbHelper.addUsers(loginResponse);
    }
    //========================== local db =========================================

    //========================= shared pref ==============================
    @Override
    public void setLoginFlag(boolean login) {
        preferencesHelper.setLoginFlag(login);
    }

    @Override
    public boolean getLoginFlag() {
        return preferencesHelper.getLoginFlag();
    }

    @Override
    public String getAuthToken() {
        return preferencesHelper.getAuthToken();
    }

    @Override
    public void setAuthToken(String authToken) {
        preferencesHelper.setAuthToken(authToken);
    }

    @Override
    public String getCurrentUserName() {
        return preferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        preferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return preferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        preferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public Integer getCurrentUserId() {
        return preferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Integer userId) {
        preferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public void setPaymentSetupInfo(String paymentHelp) {
        preferencesHelper.setPaymentSetupInfo(paymentHelp);
    }

    @Override
    public void setSubscribed(int subscribed) {
        preferencesHelper.setSubscribed(subscribed);
    }

    @Override
    public int getSubscriptionStatusPref() {
        return preferencesHelper.getSubscriptionStatusPref();
    }

    @Override
    public void setSubscriptionStatusPref(int status) {
        preferencesHelper.setSubscriptionStatusPref(status);
    }

    @Override
    public String getPhoneNumber() {
        return preferencesHelper.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        preferencesHelper.setPhoneNumber(phoneNumber);
    }

    @Override
    public String getPhoneCode() {
        return preferencesHelper.getPhoneCode();
    }

    @Override
    public void setPhoneCode(String code) {
        preferencesHelper.setPhoneCode(code);
    }

    @Override
    public void setGroupId(int id) {
        preferencesHelper.setGroupId(id);
    }

    @Override
    public int getGroupId() {
        return preferencesHelper.getGroupId();
    }

    @Override
    public String getCountryName() {
        return preferencesHelper.getCountryName();
    }

    @Override
    public void setCountryName(String name) {
        preferencesHelper.setCountryName(name);
    }

    @Override
    public void setFarmCount(Integer farmCount) {
        preferencesHelper.setFarmCount(farmCount);
    }

    @Override
    public Integer getFarmCount() {
        return preferencesHelper.getFarmCount();
    }

    @Override
    public void setProfileImage(String profileImage) {
        preferencesHelper.setProfileImage(profileImage);
    }

    @Override
    public String getProfileImage() {
        return preferencesHelper.getProfileImage();
    }
    //================= shared pref =====================================
}
