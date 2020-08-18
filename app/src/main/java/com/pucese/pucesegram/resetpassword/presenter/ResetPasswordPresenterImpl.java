package com.pucese.pucesegram.resetpassword.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.resetpassword.interactor.ResetPasswordInteractor;
import com.pucese.pucesegram.resetpassword.interactor.ResetPasswordInteractorImpl;
import com.pucese.pucesegram.resetpassword.view.ResetPasswordView;

public class ResetPasswordPresenterImpl implements ResetPasswordPresenter{
    private ResetPasswordView view;
    private ResetPasswordInteractor interactor;

    public ResetPasswordPresenterImpl(ResetPasswordView view) {
        this.view = view;
        interactor = new ResetPasswordInteractorImpl(this);
    }

    @Override
    public void ResetPassword(String email, FirebaseAuth mAuth) {
        interactor.ResetPassword(email, mAuth);
    }

    @Override
    public void ResetPasswordSucces() {
        view.goLogin();
        view.ResetPasswordSucces();
    }

    @Override
    public void ResetPasswordError(String error) {
        view.ResetPasswordError(error);
    }
}
