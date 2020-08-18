package com.pucese.pucesegram.createaccount.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.createaccount.interactor.CreateAccountInteractor;
import com.pucese.pucesegram.createaccount.interactor.CreateAccountInteractorImpl;
import com.pucese.pucesegram.createaccount.view.CreateAccountView;

public class CreateAccountPresenterImpl implements CreateAccountPresenter{
    private CreateAccountView view;
    private CreateAccountInteractor interactor;

    public CreateAccountPresenterImpl(CreateAccountView view) {
        this.view = view;
        interactor = new CreateAccountInteractorImpl(this);
    }


    @Override
    public void createAccount(String name, String email, String username, String password, String confpassword, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        interactor.createAccount(name, email, username, password, confpassword, mAuth, mDatabase);
    }

    @Override
    public void createAccountSucces() {
        view.goLogin();
        view.createAccountSucces();
    }

    @Override
    public void createAccountError(String error) {
        view.createAccountError(error);
    }
}
