package com.example.nischal.ricardoappexercise.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.example.nischal.ricardoappexercise.data.AppDataManager;
import com.example.nischal.ricardoappexercise.data.DataManager;
import com.example.nischal.ricardoappexercise.data.local.db.AppDbHelper;
import com.example.nischal.ricardoappexercise.data.local.db.DbHelper;
import com.example.nischal.ricardoappexercise.data.local.prefs.AppPreferenceHelper;
import com.example.nischal.ricardoappexercise.data.local.prefs.PreferencesHelper;
import com.example.nischal.ricardoappexercise.di.DatabaseInfo;
import com.example.nischal.ricardoappexercise.di.PreferenceInfo;
import com.example.nischal.ricardoappexercise.helper.AppConstants;
import com.example.nischal.ricardoappexercise.util.rx.AppSchedulerProvider;
import com.example.nischal.ricardoappexercise.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Provides
    @Singleton
    Resources provideResources(Application application){
        return application.getResources();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferenceHelper(AppPreferenceHelper preferenceHelper){
        return preferenceHelper;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper){
        return appDbHelper;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    Realm provideRealm(){
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    RealmConfiguration realmConfiguration(Application application, @DatabaseInfo String databaseName){
        Realm.init(application);
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.name(databaseName);
        builder = builder.deleteRealmIfMigrationNeeded();
        return builder.build();
    }
}
