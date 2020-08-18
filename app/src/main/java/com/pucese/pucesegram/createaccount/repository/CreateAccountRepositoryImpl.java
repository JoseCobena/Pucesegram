package com.pucese.pucesegram.createaccount.repository;

import android.support.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.pucese.pucesegram.createaccount.presenter.CreateAccountPresenter;


import java.util.HashMap;

public class CreateAccountRepositoryImpl implements CreateAccountRepository{
    private CreateAccountPresenter presenter;

    public CreateAccountRepositoryImpl(CreateAccountPresenter presenter) {
        this.presenter= presenter;
    }

    @Override
    public void createAccount(String name, String email, String username, String password, String confpassword, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        if (!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !confpassword.isEmpty()){
            if (password.length() >=8){
                if (password.matches("(.*[0-9].*)")){
                    if (password.matches("(.*[A-Z].*)")){
                        if (password.matches("^(?=.*[_.*()*#!/$&@]).*$")){
                            if (password.equals(confpassword)) {
                                Register(name, email, username, password, confpassword, mAuth, mDatabase);
                            }else{
                                presenter.createAccountError("Las contraseñas deben ser iguales");
                            }
                        }else{
                            presenter.createAccountError("La contraseña requiere al menos un caracter especial");
                        }
                    }else{
                        presenter.createAccountError("La contraseña requiere mayusculas");
                    }
                }else{
                    presenter.createAccountError("La contraseña requiere al menos un numero");
                }
            }else{
                presenter.createAccountError("La contraseña debe tener al menos 8 caracteres");
            }
        }else{
            presenter.createAccountError("Debe completar todos los campos correctamente");
        }
    }

    public void Register(final String name, final String email, final String username, final String password, final String confpassword, final FirebaseAuth mAuth, final DatabaseReference mDatabase){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        try {
                            if (task.isSuccessful()) {
                                String id= mAuth.getCurrentUser().getUid();
                                HashMap<String, Object> result = new HashMap<>();
                                result.put("correo", email);
                                result.put("usuario", username);
                                result.put("nombre", name);
                                mDatabase.child("Users").child(id).setValue(result).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task2) {
                                        if(task2.isSuccessful())
                                        {
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            presenter.createAccountSucces();
                                        }
                                        else
                                        {
                                            presenter.createAccountError(task2.getException().getMessage());
                                        }
                                    }
                                });
                            } else {
                                // If sign in fails, display a message to the user.
                                presenter.createAccountError("Autentificación fallida.");
                                //updateUI(null);
                            }
                        }
                        catch (Exception ex)
                        {
                            presenter.createAccountError("Error insert:   " + ex.getMessage());
                        }
                    }
                });
    }
}
