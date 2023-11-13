package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView mSplash = findViewById(R.id.fondo);
        Glide.with(this)
                .load(R.drawable.fondo_mar)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_700)))
                .into(mSplash);
    }
}