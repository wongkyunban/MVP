package com.wong.mvpdemo.login.data.repo;

import com.wong.mvpdemo.login.data.model.User;

public class UserRepository implements LoginRepository {
    private User user;
    @Override
    public User getUser() {
        if(user == null){
            user = new User("KingWill","Wong");
            user.setId(0);
            return user;
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        if(user == null){
            user = getUser();
        }
        this.user = user;
    }
}
