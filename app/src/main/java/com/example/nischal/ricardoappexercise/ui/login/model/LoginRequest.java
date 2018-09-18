package com.example.nischal.ricardoappexercise.ui.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Utsab on 3/22/2018.
 */

public class LoginRequest {
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("device_type")
    @Expose
    public Integer deviceType = 1;
    @SerializedName("device_id")
    @Expose
    public String deviceId;
    @SerializedName("device_token")
    @Expose
    public String deviceToken;
}
