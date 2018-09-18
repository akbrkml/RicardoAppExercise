package com.example.nischal.ricardoappexercise.data.remote;


import com.example.nischal.ricardoappexercise.ui.login.model.LoginRequest;
import com.example.nischal.ricardoappexercise.ui.login.model.LoginResponse;


import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {
    @POST("login")
    Observable<LoginResponse> loginRequest(@Body LoginRequest loginRequest);

    @POST("login")
    Observable<Response<LoginResponse>> login(@Body LoginRequest loginRequest);
}
