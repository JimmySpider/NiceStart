package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.provider.ContactsContract;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();


        ImageView mSplash = findViewById(R.id.fondo);
        Glide.with(this)
                .load(R.drawable.fondo_mar)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_700)))
                .into(mSplash);
        ImageView logo;
        logo = (ImageView) findViewById(R.id.rayo);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.blink); //Para cargar una animacion en el logo, blink= efecto de parpadeo.
        logo.startAnimation(rotate);

        ImageView mLogo = findViewById(R.id.rayo);
        Glide.with(this)
                .load(R.drawable.rayologin)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mLogo);

    }

    private void openApp() { //Para que se abra el splash con efecto
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 5000);
    }
}