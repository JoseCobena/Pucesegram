package com.pucese.pucesegram.createaccount.interactor;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public interface CreateAccountInteractor {
    void createAccount(
            String name,
            String email,
            String username,
            String password,
            String confpassword,
            FirebaseAuth mAuth,
            DatabaseReference mDatabase
    );

}
