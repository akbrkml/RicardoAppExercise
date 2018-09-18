package com.example.nischal.ricardoappexercise.data.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.example.nischal.ricardoappexercise.data.common.Status.ERROR;
import static com.example.nischal.ricardoappexercise.data.common.Status.LOADING;
import static com.example.nischal.ricardoappexercise.data.common.Status.SUCCESS;
import static com.example.nischal.ricardoappexercise.data.common.Status.SUCCESSANDNAVIGATE;

public class LiveDataResponse<T> {
    public final Status status;

    @Nullable
    public final int requestCode;

    @Nullable
    public final T data;

    @Nullable
    public final String error;

    public LiveDataResponse(Status status, T data, String error, int requestCode) {
        this.status = status;
        this.requestCode = requestCode;
        this.data = data;
        this.error = error;
    }

    public static LiveDataResponse loading(int requestCode) {
        return new LiveDataResponse(LOADING, null, null, requestCode);
    }

    public static <T> LiveDataResponse success(@NonNull T data, int requestCode) {
        return new LiveDataResponse(SUCCESS, data, null, requestCode);
    }

    public static LiveDataResponse error(@NonNull String error, int requestCode) {
        return new LiveDataResponse(ERROR, null, error, requestCode);
    }

    public static <T> LiveDataResponse successAndNavigate(@NonNull T data, int requestCode){
        return new LiveDataResponse(SUCCESSANDNAVIGATE,data,null,requestCode);
    }
}
