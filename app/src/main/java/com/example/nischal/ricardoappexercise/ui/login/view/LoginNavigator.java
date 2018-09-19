package com.example.nischal.ricardoappexercise.ui.login.view;

import com.example.nischal.ricardoappexercise.ui.login.model.LoginResponse;

public interface LoginNavigator {
    void openSelectUserRegisterActivity();

    void openContactVerificationDialog(LoginResponse.Data contact);
}
