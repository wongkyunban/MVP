package com.wong.mvpdemo.login.data.repo;

import com.wong.mvpdemo.login.data.model.User;

public interface LoginRepository {
    User getUser();
    void saveUser(User user);
}
