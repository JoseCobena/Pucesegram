package com.pucese.pucesegram.createaccount.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pucese.pucesegram.createaccount.presenter.CreateAccountPresenter;
import com.pucese.pucesegram.createaccount.presenter.CreateAccountPresenterImpl;
import com.pucese.pucesegram.login.view.LoginActivity;
import com.pucese.pucesegram.R;


public class CreateAccountActivity extends AppCompatActivity implements CreateAccountView
{

    private CreateAccountPresenter presenter;
    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private EditText mEditTextConfirmPass;
    private Button mButtonRegister;


    private String name ="";
    private String email ="";
    private String username ="";
    private String password ="";
    private String confpassword ="";
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_createaccount),true);

        mAuth = FirebaseAuth.getInstance();
        try {
            mDatabase = FirebaseDatabase.getInstance().getReference();
        }
        catch ( Exception ex)
        {
            Toast.makeText(getApplicationContext(),"Inicializado: " + ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        mAuth = FirebaseAuth.getInstance();
        mEditTextEmail = (EditText) findViewById(R.id.email);
        mEditTextName = (EditText) findViewById(R.id.name);
        mEditTextUsername = (EditText) findViewById(R.id.user);
        mEditTextPassword = (EditText) findViewById(R.id.password_createaccount);
        mEditTextConfirmPass = (EditText) findViewById(R.id.confirmPassword);
        mButtonRegister = (Button) findViewById(R.id.joiUs);
        presenter = new CreateAccountPresenterImpl(this);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mEditTextName.getText().toString();
                email = mEditTextEmail.getText().toString();
                username = mEditTextUsername.getText().toString();
                password = mEditTextPassword.getText().toString();
                confpassword = mEditTextConfirmPass.getText().toString();
                presenter.createAccount(name, email, username, password, confpassword, mAuth, mDatabase);
            }
        });
    }

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public void createAccountSucces() {
        Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void createAccountError(String error) {
        Toast.makeText(this, "Ha ocurrido un error"+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}
