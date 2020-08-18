package com.pucese.pucesegram.login.interactor;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.login.presenter.LoginPresenter;
import com.pucese.pucesegram.login.repository.LoginRepository;
import com.pucese.pucesegram.login.repository.LoginRepositoryImpl;

public class LoginInteractorImpl implements LoginInteractor{
    private LoginPresenter presenter;
    private LoginRepository repository;
    public LoginInteractorImpl(LoginPresenter presenter) {
        this.presenter = presenter;
        repository = new LoginRepositoryImpl(presenter);
    }
    @Override
    public void singIn(String username, String password, FirebaseAuth btnAuth) {
        repository.singIn(username, password, btnAuth);
    }}
