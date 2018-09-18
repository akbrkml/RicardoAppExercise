package com.example.nischal.ricardoappexercise.ui.login.view;

import android.arch.lifecycle.ViewModelProvider;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nischal.ricardoappexercise.R;
import com.example.nischal.ricardoappexercise.base.BaseActivity;
import com.example.nischal.ricardoappexercise.data.common.LiveDataResponse;
import com.example.nischal.ricardoappexercise.helper.AppConstants;
import com.example.nischal.ricardoappexercise.ui.login.viewmodel.LoginViewModel;
import com.example.nischal.ricardoappexercise.util.CommonUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    public static final String TAG = LoginActivity.class.getSimpleName();

    @Inject
    LoginViewModel loginViewModel;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @BindView(R.id.constraint_layout_login)
    ConstraintLayout clLogin;
    @BindView(R.id.email_edit_text)
    EditText emailEditText;
    @BindView(R.id.password_edit_text)
    EditText passwordEditText;
    @BindView(R.id.login_button)
    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUI(clLogin, this);

    }

    @OnClick(R.id.login_button)
    void loginUserClicked(){
        Log.i(TAG + "isClicked: ", "ok");
        if (emailEditText.getText().toString().equalsIgnoreCase(AppConstants.DEMO_USER.email)) {
            loginViewModel.logInUser(emailEditText.getText().toString(), passwordEditText.getText().toString(), CommonUtils.getDeviceId(this), "demo-account-token", AppConstants.REQUEST_USER_LOGIN);
        } else {
//            tokenRequest();
            loginViewModel.logInUser(emailEditText.getText().toString().trim(), passwordEditText.getText().toString().trim(), CommonUtils.getDeviceId(this), "device-token", AppConstants.REQUEST_USER_LOGIN);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        loginViewModel.getResponse().observe(this, liveDataResponse -> processResponse(liveDataResponse));
        loginViewModel.setBaseModel();
    }

    @Override
    public void processResponse(LiveDataResponse liveDataResponse) {
        Log.i(TAG+"process response ", liveDataResponse.status.toString());
    }
}
