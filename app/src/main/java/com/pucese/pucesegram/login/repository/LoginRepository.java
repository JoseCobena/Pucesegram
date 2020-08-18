package com.pucese.pucesegram.login.repository;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginRepository {
    void singIn(String username, String password, FirebaseAuth btnAuth);

}
