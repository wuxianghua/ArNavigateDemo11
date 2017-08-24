package com.example.administrator.arnavigatedemo;

import android.app.Application;

import com.palmaplus.nagrand.core.Engine;

/**
 * Created by Administrator on 2017/7/28/028.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FileUtilsTools.copyDirToSDCardFromAsserts(this, "Nagrand/lua", "font");
        FileUtilsTools.copyDirToSDCardFromAsserts(this, "Nagrand/lua", "Nagrand/lua");

        // init Engine
        Engine instance = Engine.getInstance();
        instance.startWithLicense(Constants.AppKey, this);
    }
}
