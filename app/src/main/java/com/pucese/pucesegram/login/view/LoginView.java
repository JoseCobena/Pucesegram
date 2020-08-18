package com.pucese.pucesegram.login.view;

public interface LoginView {
    void goHome();
    void goCreateAccount();
    void ResetPassword();
    void loginError(String error);
}
