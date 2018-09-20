package com.example.nischal.ricardoappexercise.data;

import com.example.nischal.ricardoappexercise.data.local.db.DbHelper;
import com.example.nischal.ricardoappexercise.data.local.prefs.PreferencesHelper;
import com.example.nischal.ricardoappexercise.data.remote.ApiServices;

public interface DataManager extends ApiServices, PreferencesHelper, DbHelper {
}
