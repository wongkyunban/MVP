package com.wong.mvpdemo.login.data.model;

import com.wong.mvpdemo.login.LoginActivityMVP;
import com.wong.mvpdemo.login.data.repo.LoginRepository;

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        if(repository == null) return;
        repository.saveUser(new User(firstName,lastName));
    }

    @Override
    public User getUser() {
        if(repository != null) return repository.getUser();
        return null;
    }
}
