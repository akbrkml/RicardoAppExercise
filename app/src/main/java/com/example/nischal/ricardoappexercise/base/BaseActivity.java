package com.example.nischal.ricardoappexercise.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.nischal.ricardoappexercise.data.common.LiveDataResponse;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public abstract class BaseActivity<V extends BaseViewModel> extends AppCompatActivity{
    private V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performBindingViewModel();
        performButterKnifeBind();
    }

    private void performBindingViewModel() {
        this.viewModel = viewModel == null? getViewModel() : viewModel;
    }

    protected abstract V getViewModel();

    public abstract void init();

    public abstract @LayoutRes
    int getLayoutId();

    public abstract void processResponse(LiveDataResponse liveDataResponse);

    public void performDependencyInjection(){
        AndroidInjection.inject(this);
    }

    public void performButterKnifeBind(){
        super.setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    public void setupUI(View view, final Activity baseActivity){
        if(!(view instanceof EditText)){
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(baseActivity);
                    return false;
                }
            });
        }
        if(view instanceof ViewGroup){
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView, baseActivity);
            }
        }
    }

    private void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }
    }
}
