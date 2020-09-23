package com.wong.mvpdemo.login;

import com.wong.mvpdemo.login.data.model.User;

public interface LoginActivityMVP {
    /**
     * View接口
     */
    interface View {
        String getFirstName();

        String getLastName();

        void showInputError();

        void showUserSavedMessage();

        void setFirstName(String firstName);

        void setLastName(String lastName);
    }

    /**
     * Presenter接口
     */
    interface Presenter {
        void setView(View view);

        void loginButtonClick();

        void getCurrentUser();
    }

    /**
     * Model接口
     */
    interface Model {
        void createUser(String firstName, String lastName);

        User getUser();
    }
}
