package com.example.nischal.ricardoappexercise.data.local.db;

import com.example.nischal.ricardoappexercise.ui.login.model.LoginResponse;

public interface DbHelper {


    void addUsers(LoginResponse.Data loginResponse);
}
