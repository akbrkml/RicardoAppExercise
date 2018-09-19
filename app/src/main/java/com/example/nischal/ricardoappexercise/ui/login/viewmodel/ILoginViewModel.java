package com.example.nischal.ricardoappexercise.ui.login.viewmodel;

public interface ILoginViewModel {
    void logInUser(String email, String password, String deviceId,String fireBaseToken, int request_code);
    void openSelectUserRegisterActivity();
}
