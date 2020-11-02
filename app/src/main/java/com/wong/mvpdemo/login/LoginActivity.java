package com.wong.mvpdemo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wong.mvpdemo.App;
import com.wong.mvpdemo.R;
import com.wong.mvpdemo.login.data.model.LoginModel;
import com.wong.mvpdemo.login.data.repo.LoginRepository;
import com.wong.mvpdemo.login.data.repo.UserRepository;
import com.wong.mvpdemo.login.LoginActivityMVP;
import com.wong.mvpdemo.login.LoginActivityPresenter;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View{

    @Inject
    LoginActivityMVP.Presenter presenter;

    private EditText mETFirstName;
    private EditText mETLastName;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mETFirstName = findViewById(R.id.loginActivity_firstName_editText);
        mETLastName = findViewById(R.id.loginActivity_lastName_editText);
        mBtnLogin = findViewById(R.id.loginActivity_login_button);
        ((App)getApplication()).getComponent().inject(this);
//        LoginRepository repository = new UserRepository();
//        LoginActivityMVP.Model model = new LoginModel(repository);
//        presenter = new LoginActivityPresenter(model);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return mETFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return mETLastName.getText().toString();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this,"First Name or Last Name cannot be enmpty",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this,"User saved successfully",Toast.LENGTH_LONG).show();

    }

    @Override
    public void setFirstName(String firstName) {
        this.mETFirstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.mETLastName.setText(lastName);
    }
}