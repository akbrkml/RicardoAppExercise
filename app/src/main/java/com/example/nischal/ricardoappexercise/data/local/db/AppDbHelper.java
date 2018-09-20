package com.example.nischal.ricardoappexercise.data.local.db;

import android.content.res.Resources;
import android.util.Log;

import com.example.nischal.ricardoappexercise.data.local.prefs.PreferencesHelper;
import com.example.nischal.ricardoappexercise.data.model.User;
import com.example.nischal.ricardoappexercise.ui.login.model.LoginResponse;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

public class AppDbHelper implements DbHelper{

    private final Realm mRealm;
    private final Gson gson;
    private final Resources resources;
    PreferencesHelper preferencesHelper;

    @Inject
    public AppDbHelper(Realm realm, Resources resources, Gson gson, PreferencesHelper preferencesHelper) {
        this.mRealm = realm;
        this.gson = gson;
        this.resources = resources;
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public void addUsers(LoginResponse.Data loginResponse) {

        User userDb1 = mRealm.where(User.class).equalTo("id", loginResponse.id).findFirst();

        mRealm.beginTransaction();
        User userDb = new User();
        userDb.setId(loginResponse.id);
        userDb.setEmail(loginResponse.email);
        userDb.setPostCode(loginResponse.postcode);
        userDb.setPhoneNumber(loginResponse.phoneNumber);
        userDb.setCountryCode(loginResponse.countryCode);
        userDb.setCountry(loginResponse.country);
        userDb.setPhoneCode(loginResponse.phoneCode);
        userDb.setCompanyName(loginResponse.companyName);
        userDb.setAddress(loginResponse.address);
        userDb.setManaging(1);
        userDb.setStatus(loginResponse.status);
        userDb.setSubscriptionStatus(loginResponse.subscriptionStatus);
        preferencesHelper.setSubscriptionStatusPref(loginResponse.subscriptionStatus);
        userDb.setFarmOccupied(loginResponse.farmOccupied);
        userDb.setFarmCount(loginResponse.farmCount);
        if (loginResponse.subscription != null) {
            userDb.setSubscriptionText(loginResponse.subscription);
        }

        //userDb.setAccesstoken(loginResponse.authToken);
        userDb.setName(loginResponse.name);
        //userDb.setAvatar(loginResponse.avatar.path);
        userDb.setState(loginResponse.state);
        userDb.setSuburb(loginResponse.suburb);
        userDb.setType(loginResponse.groupId);
        userDb.setSubscriptionText(loginResponse.subscription);
        userDb.setSubscriptionType(loginResponse.subscriptionType);
        if (loginResponse.avatar != null) {
            userDb.setAvatar(loginResponse.avatar.path);
            userDb.setImageId(loginResponse.avatar.id);

            // userDb.setAvatar(loginResponse.avatar.);
        }
        if (userDb1 == null) {
            userDb.setTimeStamp(0);
        }
        if (loginResponse.paymentMethods != null) {
            userDb.setCardNumber(loginResponse.paymentMethods.cardNumber);
            userDb.setCardToken(loginResponse.paymentMethods.token);
            userDb.setExpiresat(loginResponse.paymentMethods.expiresAt);

        }
        mRealm.copyToRealmOrUpdate(userDb);
        mRealm.commitTransaction();
        RealmResults<User> list = mRealm.where(User.class).findAll();
        Log.d("list", list.size() + "");
        Log.d("userdg", userDb.getId() + "");
        Log.d("username", userDb.getName() + "");
        Log.d("timestamp", userDb.getTimeStamp() + "");
    }
}
