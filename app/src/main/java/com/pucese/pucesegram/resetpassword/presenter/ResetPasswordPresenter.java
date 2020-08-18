package com.pucese.pucesegram.resetpassword.presenter;

import com.google.firebase.auth.FirebaseAuth;

public interface ResetPasswordPresenter {
    void ResetPassword(
            String email,
            FirebaseAuth mAuth
    );
    void ResetPasswordSucces();
    void ResetPasswordError(String error);
}
