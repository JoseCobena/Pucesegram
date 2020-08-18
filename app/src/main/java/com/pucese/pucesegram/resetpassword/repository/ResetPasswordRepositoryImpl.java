package com.pucese.pucesegram.resetpassword.repository;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.resetpassword.presenter.ResetPasswordPresenter;

public class ResetPasswordRepositoryImpl implements ResetPasswordRepository{
    private ResetPasswordPresenter presenter;

    public ResetPasswordRepositoryImpl(ResetPasswordPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void ResetPassword( String email, FirebaseAuth mAuth) {
        if (!email.isEmpty()) {
            Reset(email,mAuth);
        }else{
            presenter.ResetPasswordError("Debe ingresar el email");
        }
    }
    public void Reset(final String email, final FirebaseAuth mAuth){
        mAuth.setLanguageCode("en");;
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    presenter.ResetPasswordSucces();
                }else{
                    presenter.ResetPasswordError("No se pudo enviar el correo de restablecer contraseña");
                }
            }
        });
    }
}
