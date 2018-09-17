package com.example.nischal.ricardoappexercise.ui.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nischal.ricardoappexercise.R;
import com.example.nischal.ricardoappexercise.base.BaseActivity;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        text.setText(R.string.test);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }
}
