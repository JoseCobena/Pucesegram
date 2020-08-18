package com.pucese.pucesegram.createaccount.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public interface CreateAccountRepository {
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
