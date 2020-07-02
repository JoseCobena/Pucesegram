package com.pucese.pucesegram.view;

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
import com.pucese.pucesegram.LoginActivity;
import com.pucese.pucesegram.R;

public class ResetPasswordActivity extends AppCompatActivity {
    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
    private EditText mEditTextEmail;
    private Button mButtonResertPassword;
    private String email = "";
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        showToolbar(getResources().getString(R.string.Reset_Password),true);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mButtonResertPassword = (Button) findViewById(R.id.ResetPassword);

        mButtonResertPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEditTextEmail.getText().toString();
                if (!email.isEmpty()) {
                    mDialog.setMessage("Espere un momento...");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    resetPassword();
                }else{
                    Toast.makeText(ResetPasswordActivity.this, "Debe ingresar el email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void resetPassword(){
        mAuth.setLanguageCode("en");;
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ResetPasswordActivity.this, "Se ha enviado un correo para restablecer tu contraseña", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ResetPasswordActivity.this, "No se pudo enviar el correo de restablecer contraseña", Toast.LENGTH_SHORT).show();
                }
                mDialog.dismiss();
            }
        });


    }
}