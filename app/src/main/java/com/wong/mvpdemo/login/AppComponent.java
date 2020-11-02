package com.wong.mvpdemo.login;

import com.wong.mvpdemo.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, LoginModule.class})
public interface AppComponent {
    void inject(LoginActivity target);
}
