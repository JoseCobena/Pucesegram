package com.pucese.pucesegram.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.LoginActivity;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.adapter.Adapter;

public class HomeActivity extends AppCompatActivity {
    RecyclerView ViewRecycler;

    String s1[];
    int images[] = {R.drawable.portete, R.drawable.portete, R.drawable.portete};
    private Button mButtonSignOut;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewRecycler = findViewById(R.id.ViewRecycler);
        s1 = getResources().getStringArray(R.array.Lugares_tuísticos);

        Adapter adapter = new Adapter(this, s1, images);
        ViewRecycler.setAdapter(adapter);
        ViewRecycler.setLayoutManager(new LinearLayoutManager(this));

        showToolbar(getResources().getString(R.string.toolbar_home),false);
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

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
