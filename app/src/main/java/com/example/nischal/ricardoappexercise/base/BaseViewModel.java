package com.example.nischal.ricardoappexercise.base;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.nischal.ricardoappexercise.data.DataManager;
import com.example.nischal.ricardoappexercise.data.common.LiveDataResponse;
import com.example.nischal.ricardoappexercise.util.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<M, N> extends ViewModel implements LifecycleObserver{

    private M baseModel;
    private N navigator;
    private DataManager dataManager;
    private CompositeDisposable compositeDisposable;
    private final SchedulerProvider schedulerProvider;
    private final MutableLiveData<LiveDataResponse> response;

    public BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
        this.dataManager = dataManager;
        this.compositeDisposable = new CompositeDisposable();
        this.response = new MutableLiveData<>();
    }

    public M getBaseModel() {
        return baseModel;
    }

    public void setBaseModel(M baseModel) {
        this.baseModel = baseModel;
    }

    public N getNavigator() {
        return navigator;
    }

    public void setNavigator(N navigator) {
        this.navigator = navigator;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public MutableLiveData<LiveDataResponse> getResponse() {
        return response;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
