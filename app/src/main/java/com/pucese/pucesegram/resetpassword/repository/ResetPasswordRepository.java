package com.pucese.pucesegram.resetpassword.repository;

import com.google.firebase.auth.FirebaseAuth;

public interface ResetPasswordRepository {
    void ResetPassword(
            String email,
            FirebaseAuth mAuth
    );
}
