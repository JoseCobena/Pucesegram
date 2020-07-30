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
import com.pucese.pucesegram.view.ContainerActivity;
import com.pucese.pucesegram.view.CreateAccountActivity;
import com.pucese.pucesegram.view.HomeActivity;
import com.pucese.pucesegram.view.ResetPasswordActivity;
import com.pucese.pucesegram.view.fragment.HomeFragment;

public class LoginActivity extends AppCompatActivity
{
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditTextEmail= (EditText) findViewById(R.id.email);
        mEditTextPassword = (EditText) findViewById(R.id.password);
        mButtonLogin = (Button) findViewById(R.id.login);


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "";
                String password = "";
                mAuth = FirebaseAuth.getInstance();

                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();
                if(!email.isEmpty() && !password.isEmpty()){
                    loginUser(mAuth, email, password);
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
    public void goResetPassword(View view)
    {
        Intent intent=new Intent(this, ResetPasswordActivity.class);
        startActivity(intent);
    }

    private void loginUser(FirebaseAuth btnAuth, String email, String password){
        btnAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "No es posible iniciar sesión, compruebe sus datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
