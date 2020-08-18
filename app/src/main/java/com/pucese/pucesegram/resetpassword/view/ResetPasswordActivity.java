package com.pucese.pucesegram.resetpassword.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.login.view.LoginActivity;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.resetpassword.presenter.ResetPasswordPresenter;
import com.pucese.pucesegram.resetpassword.presenter.ResetPasswordPresenterImpl;

public class ResetPasswordActivity extends AppCompatActivity implements ResetPasswordView{
    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
    private ResetPasswordPresenter presenter;

    private EditText mEditTextEmail;
    private Button mButtonResetPassword;
    private String email = "";
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        showToolbar(getResources().getString(R.string.Reset_Password),true);

        mAuth = FirebaseAuth.getInstance();
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mButtonResetPassword = (Button) findViewById(R.id.ResetPassword);
        presenter = new ResetPasswordPresenterImpl(this);

        mButtonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEditTextEmail.getText().toString();
                presenter.ResetPassword(email,mAuth);
            }
        });
    }

    @Override
    public void ResetPasswordSucces() {
        Toast.makeText(this, "Se ha enviado un correo para restablecer tu contraseña", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ResetPasswordError(String error) {
        Toast.makeText(this, "Ha ocurrido un error"+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}