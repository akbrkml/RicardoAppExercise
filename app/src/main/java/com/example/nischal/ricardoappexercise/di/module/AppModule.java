package com.example.nischal.ricardoappexercise.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.example.nischal.ricardoappexercise.data.AppDataManager;
import com.example.nischal.ricardoappexercise.data.DataManager;
import com.example.nischal.ricardoappexercise.util.rx.AppSchedulerProvider;
import com.example.nischal.ricardoappexercise.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
}
