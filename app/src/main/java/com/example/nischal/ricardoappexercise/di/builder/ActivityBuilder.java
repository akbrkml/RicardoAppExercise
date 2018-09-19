package com.example.nischal.ricardoappexercise.di.builder;

import com.example.nischal.ricardoappexercise.ui.login.view.LoginActivity;
import com.example.nischal.ricardoappexercise.ui.login.LoginActivityModule;
import com.example.nischal.ricardoappexercise.ui.selectUser.SelectUserRegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {LoginActivityModule.class})
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector()
    abstract SelectUserRegisterActivity selectUserRegisterActivity();
}
