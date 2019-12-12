package com.example.magazine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class userpage extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button logout;
    private RecyclerView list;
    ArrayList<Integer> imageid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);
        auth= FirebaseAuth.getInstance();
        logout= findViewById(R.id.logout);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        final GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleSignInClient.signOut();
                auth.signOut();
                startActivity(new Intent(userpage.this,MainActivity.class));
            }
        });


      imageid = new ArrayList<>();
      imageid.add(R.drawable.bleu1);
        imageid.add(R.drawable.bleu2);
        imageid.add(R.drawable.bleu3);
        imageid.add(R.drawable.bleu3);
        imageid.add(R.drawable.bleu4);
        imageid.add(R.drawable.bleu5);
        imageid.add(R.drawable.bleu6);
        imageid.add(R.drawable.bleu7);
        list = findViewById(R.id.list);

        list.setAdapter(new ListAdapter(imageid));

    }
}
