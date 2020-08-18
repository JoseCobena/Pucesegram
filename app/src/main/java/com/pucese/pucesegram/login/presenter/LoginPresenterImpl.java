package com.pucese.pucesegram.login.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.login.interactor.LoginInteractor;
import com.pucese.pucesegram.login.interactor.LoginInteractorImpl;
import com.pucese.pucesegram.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter{
    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void singIn(String username, String password, FirebaseAuth btnAuth) {
        interactor.singIn(username, password, btnAuth);
    }

    @Override
    public void loginSucces() {
        view.goHome();
    }

    @Override
    public void loginError(String error) {
        view.loginError(error);
    }

    @Override
    public void register() {
        view.goCreateAccount();
    }

    @Override
    public void ResetPassword() {
        view.ResetPassword();
    }
}
