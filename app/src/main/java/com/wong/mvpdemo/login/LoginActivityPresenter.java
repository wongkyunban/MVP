package com.wong.mvpdemo.login;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.wong.mvpdemo.login.data.model.User;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model){
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClick() {
        if(view != null){
            if(TextUtils.isEmpty(view.getFirstName().trim()) || TextUtils.isEmpty(view.getLastName().trim())){
                view.showInputError();
            }else{
                model.createUser(view.getFirstName(),view.getLastName());
                view.showUserSavedMessage();
            }
        }

    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if(user != null && view != null){
            view.setFirstName(user.getFirstName());
            view.setLastName(user.getLastName());
        }
    }
}
