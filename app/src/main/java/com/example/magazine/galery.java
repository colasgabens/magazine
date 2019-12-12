package com.example.magazine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class galery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        getintent();
    }
    private void  getintent(){
        if(getIntent().hasExtra("mog")){

            int image = getIntent().getIntExtra("mog" ,0);
            setimage(  image);

        }
    }
    private void  setimage(int image){
        ImageView name = findViewById(R.id.galery);
        name.setImageResource(  image);
    }
}
