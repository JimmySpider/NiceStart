package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para hacer un menu tienes que crear una carpeta menu del tipo menu
        // dentro de res
        //Haces un casting al que aplicas el menu y lo registras
        TextView mycontext = (TextView) findViewById(R.id.textTap);
        registerForContextMenu(mycontext);


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

    //Y es to lo creas para que funcione, esto solo vale para dos opciones
    //Tendiras que enlazar if's
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
    }
    public boolean onContextItemSelected(MenuItem item){
        if (item.getItemId()==R.id.item1) {

            Toast toast = Toast.makeText(this, "going CONTEXT ITEM",
                    Toast.LENGTH_LONG);
            toast.show();
            return true;
        }

            else if (item.getItemId()==R.id.action_settings){
                Toast toast2 = Toast.makeText(this,"going CONTEXT SETTINGS",
                        Toast.LENGTH_LONG);
                toast2.show();
                return true;
            }
        else return super.onContextItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_2,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==R.id.action_settings){
            return true;
        }
        if(id==R.id.camera){
            Toast toast = Toast.makeText(this,"going APPBAR CAMERA",Toast.LENGTH_LONG);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }

}