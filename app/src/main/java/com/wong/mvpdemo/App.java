package com.wong.mvpdemo;

import android.app.Application;

import com.wong.mvpdemo.login.AppComponent;
import com.wong.mvpdemo.login.DaggerAppComponent;
import com.wong.mvpdemo.login.LoginModule;

public class App extends Application {
    private AppComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .loginModule(new LoginModule())
                .build();
    }
    public AppComponent getComponent() {
        return component;
    }
}