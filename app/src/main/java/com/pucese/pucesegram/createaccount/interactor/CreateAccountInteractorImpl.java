package com.pucese.pucesegram.createaccount.interactor;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.createaccount.presenter.CreateAccountPresenter;
import com.pucese.pucesegram.createaccount.repository.CreateAccountRepository;
import com.pucese.pucesegram.createaccount.repository.CreateAccountRepositoryImpl;

public class CreateAccountInteractorImpl implements CreateAccountInteractor{
    private CreateAccountPresenter presenter;
    private CreateAccountRepository repository;

    public CreateAccountInteractorImpl(CreateAccountPresenter presenter) {
        this.presenter = presenter;
        repository = new CreateAccountRepositoryImpl(presenter);
    }

    @Override
    public void createAccount(String name, String email, String username, String password, String confpassword, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        repository.createAccount(name, email, username, password, confpassword, mAuth, mDatabase);
    }
}
