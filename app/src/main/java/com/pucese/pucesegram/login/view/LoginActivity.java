package com.pucese.pucesegram.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.login.presenter.LoginPresenter;
import com.pucese.pucesegram.login.presenter.LoginPresenterImpl;
import com.pucese.pucesegram.container.view.ContainerActivity;
import com.pucese.pucesegram.createaccount.view.CreateAccountActivity;
import com.pucese.pucesegram.resetpassword.view.ResetPasswordActivity;

public class LoginActivity extends AppCompatActivity implements LoginView
{
    private LoginPresenter presenter;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    private TextView mButtonResetPassword;
    private TextView mButtonCreateAccount;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditTextEmail= (EditText) findViewById(R.id.email);
        mEditTextPassword = (EditText) findViewById(R.id.password);
        mButtonLogin = (Button) findViewById(R.id.login);
        presenter = new LoginPresenterImpl(this);
        mButtonCreateAccount = (TextView) findViewById(R.id.createHere);
        mButtonResetPassword = (TextView) findViewById(R.id.Resetpass);

        mButtonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.register();
            }
        });

        mButtonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.ResetPassword();
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "";
                String password = "";
                mAuth = FirebaseAuth.getInstance();

                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();
                presenter.singIn(email, password, mAuth);

            }
        });
    }


    @Override
    public void goHome() {
        Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void goCreateAccount() {
        Intent intent=new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
    @Override
    public void ResetPassword() {
        Intent intent=new Intent(this, ResetPasswordActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this,getString(R.string.login_error)+error, Toast.LENGTH_SHORT).show();
    }

}
