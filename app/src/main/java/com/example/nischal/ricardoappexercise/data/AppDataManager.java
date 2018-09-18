package com.example.nischal.ricardoappexercise.data;

import com.example.nischal.ricardoappexercise.data.remote.ApiServices;
import com.example.nischal.ricardoappexercise.ui.login.model.LoginRequest;
import com.example.nischal.ricardoappexercise.ui.login.model.LoginResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;

@Singleton
public class AppDataManager implements DataManager{
    private final ApiServices apiServices;

    @Inject
    public AppDataManager(ApiServices apiServices) {
        this.apiServices = apiServices;
    }

    @Override
    public Observable<LoginResponse> loginRequest(LoginRequest loginRequest) {
        return apiServices.loginRequest(loginRequest);
    }

    @Override
    public Observable<Response<LoginResponse>> login(LoginRequest loginRequest) {
        return apiServices.login(loginRequest);
    }
}
