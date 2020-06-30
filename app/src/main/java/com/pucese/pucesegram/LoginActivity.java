package com.pucese.pucesegram;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.pucese.pucesegram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void goCreateAccount(View view)
    {
        Intent intent=new Intent(this, CreateAccountActivity.class);
       startActivity(intent);
    }

}
