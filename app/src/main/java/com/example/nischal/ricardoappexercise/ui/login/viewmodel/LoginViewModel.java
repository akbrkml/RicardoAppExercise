package com.example.nischal.ricardoappexercise.ui.login.viewmodel;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import com.example.nischal.ricardoappexercise.base.BaseViewModel;
import com.example.nischal.ricardoappexercise.base.IBaseViewModel;
import com.example.nischal.ricardoappexercise.data.DataManager;
import com.example.nischal.ricardoappexercise.data.common.LiveDataResponse;
import com.example.nischal.ricardoappexercise.helper.AppConstants;
import com.example.nischal.ricardoappexercise.ui.login.model.LoginRequest;
import com.example.nischal.ricardoappexercise.ui.login.model.LoginResponse;
import com.example.nischal.ricardoappexercise.ui.login.view.LoginNavigator;
import com.example.nischal.ricardoappexercise.util.rx.SchedulerProvider;

import okhttp3.Headers;

public class LoginViewModel extends BaseViewModel<LoginResponse,LoginNavigator> implements ILoginViewModel, IBaseViewModel{

    public static final String TAG = LoginViewModel.class.getSimpleName();

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    @Override
    public void setBaseModel() {
        if(getBaseModel() == null){
            setBaseModel(new LoginResponse());
        }
    }

    @Override
    public void logInUser(String email, String password, String deviceId, String fireBaseToken, final int request_code) {
        Log.i(TAG, "inside loginUser");
        if(getBaseModel() != null){
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.email = email;
            loginRequest.password = password;
            loginRequest.deviceId = deviceId;
            loginRequest.deviceToken = fireBaseToken;
            loginRequest.deviceType =  1;
            Log.i(TAG + "loginRequest", loginRequest.email);

            if(isValid(loginRequest)){
                getCompositeDisposable().add(getDataManager().login(loginRequest)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .doOnSubscribe(x -> getResponse().setValue(LiveDataResponse.loading(request_code)))
                        .subscribe(
                                response ->{
                                    Log.i("headers ", response.headers().toString());
                                    Headers list = response.headers();

                                    setBaseModel(response.body());
                                    switch(response.body().status){
                                        case AppConstants.VerificationCode.SUCCESS:
                                            Log.i("response ", response.body().message);
                                            break;
                                        case AppConstants.VerificationCode.CONTACT_NOT_VERIFIED:
                                            Log.i("response ", response.body().message);
                                            break;
                                        case AppConstants.VerificationCode.INACTIVE_ACCOUNT:
                                            Log.i("response ", response.body().message);
                                            break;
                                        case AppConstants.VerificationCode.INCORRECT_CREDENTIALS:
                                            Log.i("response ", response.body().message);
                                            break;
                                        default:
                                            break;
                                    }
                                },
                                Throwable::printStackTrace
                        )
                );
            }
        }
    }

    private boolean isValid(LoginRequest loginRequest) {
        if(isValidEmail(loginRequest.email) && isValidPassword(loginRequest.password)){
            return true;
        }else{
            return false;
        }
    }

    private boolean isValidPassword(String password) {
        if(TextUtils.isEmpty(password)){
            getResponse().setValue(LiveDataResponse
                    .error(AppConstants.Validation.INVALID_PASSWORD, 1));
            return false;
        }else{
            return true;
        }
    }

    private boolean isValidEmail(String email) {
        if(!TextUtils.isEmpty(email)){
            if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                return true;
            }else{
                getResponse().setValue(LiveDataResponse
                        .error(AppConstants.Validation.INVALID_EMAIL, 1));
                return false;
            }
        }else{
            getResponse().setValue(LiveDataResponse
                    .error(AppConstants.Validation.EMPTY_EMAIL,1));
            return false;
        }
    }

}
