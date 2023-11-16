package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ImageView mHipp = findViewById(R.id.chico);
        Glide.with(this)
                .load(R.drawable.hipman)
                .transition(DrawableTransitionOptions.withCrossFade(4000))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.circleCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mHipp);
        ImageView mLogo = findViewById(R.id.logo);
        Glide.with(this)
                .load(R.drawable.rayologin)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mLogo);
    }


    public void openMain(View v){
        Intent intent = new Intent(Register.this,MainActivity.class);
        startActivity(intent);
    }
    public void openLogin(View v) {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }
}