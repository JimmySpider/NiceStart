package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView welcomeText = findViewById(R.id.welcomeText);

        // Definir una animación de desvanecimiento
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(3000); // Duración de la animación en milisegundos

        // Agregar un listener para iniciar otra actividad o realizar más acciones al finalizar la animación
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Acciones al iniciar la animación
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Acciones al finalizar la animación (puedes iniciar otra actividad aquí, por ejemplo)
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Acciones al repetir la animación
            }
        });

        // Aplicar la animación al TextView
        welcomeText.startAnimation(fadeIn);
        ratingBar = (RatingBar) findViewById(R.id.estrellas);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this,"Has calificado con "+rating,Toast.LENGTH_LONG).show();
            }
        });
    }

}