package com.example.nischal.ricardoappexercise.di.component;

import android.app.Application;

import com.example.nischal.ricardoappexercise.MyApplication;
import com.example.nischal.ricardoappexercise.di.builder.ActivityBuilder;
import com.example.nischal.ricardoappexercise.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {
    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MyApplication application);
}
