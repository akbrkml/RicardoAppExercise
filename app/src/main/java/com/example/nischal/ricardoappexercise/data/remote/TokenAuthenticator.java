package com.example.nischal.ricardoappexercise.data.remote;

import android.content.Context;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TokenAuthenticator implements Authenticator{
    private Context context;
    private Request request;
    ApiServiceHolder apiServiceHolder;



    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        return null;
    }
}
