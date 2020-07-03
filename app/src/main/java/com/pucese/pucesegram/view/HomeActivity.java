package com.pucese.pucesegram.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pucese.pucesegram.LoginActivity;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.adapter.Adapter;

public class HomeActivity extends AppCompatActivity {
    RecyclerView ViewRecycler;


    String s1[];
    String s2[];
    String s3[];
    int images[] = {R.drawable.portete, R.drawable.atacames, R.drawable.las_palmas, R.drawable.mompiche,
    R.drawable.muisne, R.drawable.galera, R.drawable.estero_de_platano};
    private Button mButtonSignOut;
    private FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewRecycler = findViewById(R.id.ViewRecycler);
        s1 = getResources().getStringArray(R.array.Lugares_turisticos);
        s2 = getResources().getStringArray(R.array.likes);
        s3 = getResources().getStringArray(R.array.makeCard);

        Adapter adapter = new Adapter(this, s1, s2, s3, images);
        ViewRecycler.setAdapter(adapter);
        ViewRecycler.setLayoutManager(new LinearLayoutManager(this));

        showToolbar(getResources().getString(R.string.toolbar_home),false);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

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
    public void goPictureDetail(View view)
    {
        Intent intent=new Intent(this, PictureDetailActivity.class);
        startActivity(intent);
    }
    private void getUserId(){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String name = dataSnapshot.child("name").getValue().toString();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
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
