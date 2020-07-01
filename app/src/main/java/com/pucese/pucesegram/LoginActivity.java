package com.pucese.pucesegram;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.view.CreateAccountActivity;
import com.pucese.pucesegram.view.HomeActivity;

public class LoginActivity extends AppCompatActivity
{
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    private String email = "";
    private String password = "";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mEditTextEmail= (EditText) findViewById(R.id.email);
        mEditTextPassword = (EditText) findViewById(R.id.password);
        mButtonLogin = (Button) findViewById(R.id.login);


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();
                if(!email.isEmpty() && !password.isEmpty()){
                    loginUser();
                }else{
                    Toast.makeText(LoginActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void goCreateAccount(View view)
    {
        Intent intent=new Intent(this, CreateAccountActivity.class);
       startActivity(intent);
    }

    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "No es posible iniciar sesión, compruebe sus datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
