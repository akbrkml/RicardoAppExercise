package com.example.nischal.ricardoappexercise.ui.selectUser;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.nischal.ricardoappexercise.R;
import com.example.nischal.ricardoappexercise.base.BaseActivity;
import com.example.nischal.ricardoappexercise.base.BaseViewModel;
import com.example.nischal.ricardoappexercise.data.common.LiveDataResponse;

public class SelectUserRegisterActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_user_register;
    }

    @Override
    public void processResponse(LiveDataResponse liveDataResponse) {

    }
}
