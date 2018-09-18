package com.example.nischal.ricardoappexercise.ui.login;

import android.arch.lifecycle.ViewModelProvider;

import com.example.nischal.ricardoappexercise.ViewModelProviderFactory;
import com.example.nischal.ricardoappexercise.data.DataManager;
import com.example.nischal.ricardoappexercise.ui.login.viewmodel.LoginViewModel;
import com.example.nischal.ricardoappexercise.util.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    LoginViewModel provideLandingViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new LoginViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory loginViewModelProvider(LoginViewModel landingViewModel) {
        return new ViewModelProviderFactory<>(landingViewModel);
    }
}
