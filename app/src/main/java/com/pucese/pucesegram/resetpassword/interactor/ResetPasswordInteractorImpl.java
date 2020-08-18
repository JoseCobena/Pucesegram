package com.pucese.pucesegram.resetpassword.interactor;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.resetpassword.presenter.ResetPasswordPresenter;
import com.pucese.pucesegram.resetpassword.repository.ResetPasswordRepository;
import com.pucese.pucesegram.resetpassword.repository.ResetPasswordRepositoryImpl;

public class ResetPasswordInteractorImpl implements ResetPasswordInteractor{
    private ResetPasswordPresenter presenter;
    private ResetPasswordRepository repository;

    public ResetPasswordInteractorImpl(ResetPasswordPresenter presenter) {
        this.presenter = presenter;
        repository = new ResetPasswordRepositoryImpl(presenter);
    }

    @Override
    public void ResetPassword(String email, FirebaseAuth mAuth) {
        repository.ResetPassword(email, mAuth);
    }
}
