package com.example.nischal.ricardoappexercise.data.remote;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiServiceHolder {
    ApiServices apiServices;

    @Inject
    public ApiServiceHolder(){

    }

    public void setApiServices(ApiServices apiServices) {
        this.apiServices = apiServices;
    }

    public ApiServices getApiServices() {
        return apiServices;
    }
}
