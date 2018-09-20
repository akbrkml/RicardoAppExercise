package com.example.nischal.ricardoappexercise;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.example.nischal.ricardoappexercise.di.component.DaggerAppComponent;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    RealmConfiguration realmConfiguration;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        Realm.setDefaultConfiguration(realmConfiguration);
        Log.d("Realm config", "path: " + realmConfiguration.getRealmDirectory());

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build()
        );
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
