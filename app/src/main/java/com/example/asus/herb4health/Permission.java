package com.example.asus.herb4health;

import android.app.Application;

import com.karumi.dexter.Dexter;

/**
 * Created by mootorn on 7/15/2017 AD.
 */

public class Permission extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Dexter.initialize(getApplicationContext());
    }

}