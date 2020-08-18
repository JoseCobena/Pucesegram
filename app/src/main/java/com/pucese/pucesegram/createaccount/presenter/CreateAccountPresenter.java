package com.pucese.pucesegram.createaccount.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public interface CreateAccountPresenter {
    void createAccount(
            String name,
            String email,
            String username,
            String password,
            String confpassword,
            FirebaseAuth mAuth,
            DatabaseReference mDatabase
    );
    void createAccountSucces();
    void createAccountError(String error);
}
