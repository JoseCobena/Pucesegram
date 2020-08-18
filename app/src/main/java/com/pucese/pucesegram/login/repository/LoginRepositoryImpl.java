package com.pucese.pucesegram.login.repository;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.login.presenter.LoginPresenter;

public class LoginRepositoryImpl implements LoginRepository{
    private LoginPresenter presenter;
    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void singIn(String username, String password, FirebaseAuth btnAuth) {
        if(!username.isEmpty() && !password.isEmpty()) {
            btnAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        presenter.loginSucces();
                    }else{
                        presenter.loginError("No es posible iniciar sesión, compruebe sus datos");
                    }
                }
            });
        }
        else {
            presenter.loginError("Complete todos los campos");
        }

    }
}
