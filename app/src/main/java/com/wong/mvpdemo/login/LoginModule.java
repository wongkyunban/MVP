package com.wong.mvpdemo.login;

import com.wong.mvpdemo.login.data.model.LoginModel;
import com.wong.mvpdemo.login.data.repo.LoginRepository;
import com.wong.mvpdemo.login.data.repo.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }
    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository repository){
        return new LoginModel(repository);
    }
    @Provides
    public LoginRepository provideLoginRepository(){
        return new UserRepository();
    }
}
