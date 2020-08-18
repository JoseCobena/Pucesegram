package com.pucese.pucesegram.login.presenter;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginPresenter {
    void singIn(String username, String password, FirebaseAuth btnAuth); //Interactor
    void loginSucces();
    void loginError(String error);
    void register();
    void ResetPassword();

}
