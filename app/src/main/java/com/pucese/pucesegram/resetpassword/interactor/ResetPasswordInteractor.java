package com.pucese.pucesegram.resetpassword.interactor;

import com.google.firebase.auth.FirebaseAuth;

public interface ResetPasswordInteractor {
    void ResetPassword(
            String email,
            FirebaseAuth mAuth
    );
}
