package com.example.nischal.ricardoappexercise.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

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
}
