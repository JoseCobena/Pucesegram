package com.pucese.pucesegram.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.LoginActivity;
import com.pucese.pucesegram.R;

public class HomeActivity extends AppCompatActivity {
    private Button mButtonSignOut;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_picture);
        mAuth = FirebaseAuth.getInstance();
        mButtonSignOut = (Button) findViewById(R.id.signOut);
        mButtonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
            }
        });

    }
}
