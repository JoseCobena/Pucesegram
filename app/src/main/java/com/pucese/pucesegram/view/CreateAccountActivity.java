package com.pucese.pucesegram.view;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pucese.pucesegram.LoginActivity;
import com.pucese.pucesegram.R;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountActivity extends AppCompatActivity
{
    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private EditText mEditTextConfirmPass;
    private Button mButtonRegister;

    private String name ="";
    private String email ="";
    private String username ="";
    private String password ="";
    private String confpassword ="";
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_createaccount),true);

        mAuth = FirebaseAuth.getInstance();
        mEditTextEmail = (EditText) findViewById(R.id.email);
        mEditTextName = (EditText) findViewById(R.id.name);
        mEditTextUsername = (EditText) findViewById(R.id.user);
        mEditTextPassword = (EditText) findViewById(R.id.password_createaccount);
        mEditTextConfirmPass = (EditText) findViewById(R.id.confirmPassword);
        mButtonRegister = (Button) findViewById(R.id.joiUs);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mEditTextName.getText().toString();
                email = mEditTextEmail.getText().toString();
                username = mEditTextUsername.getText().toString();
                password = mEditTextPassword.getText().toString();
                confpassword = mEditTextConfirmPass.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !confpassword.isEmpty()){
                    if (password.length() >=6){
                        registerUser();
                    }else{
                        Toast.makeText(CreateAccountActivity.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CreateAccountActivity.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("email", email);
                    map.put("name", name);
                    map.put("username", username);
                    map.put("password", password);

                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(CreateAccountActivity.this, LoginActivity.class));
                                finish();
                            }else{
                                Toast.makeText(CreateAccountActivity.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(CreateAccountActivity.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
