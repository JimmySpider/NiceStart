package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;


public class Nopeople extends AppCompatActivity {

    private WebView mi_Visor_Web;
    private SwipeRefreshLayout swipe_Layaout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nopeople);

        //Creamos la variable para el swipe
        swipe_Layaout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipe_Layaout.setOnRefreshListener(mOnRefreshListener);
        mi_Visor_Web = (WebView) findViewById(R.id.vistaweb);

        WebSettings webSettings = mi_Visor_Web.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        mi_Visor_Web.loadUrl("https://thispersondoesnotexist.com/");

    }
    protected SwipeRefreshLayout.OnRefreshListener

    mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //Toast es para que salga un mensaje en pop up en pantalla
            Toast toast0 = Toast.makeText(Nopeople.this,"Hi there! I don't exit :",Toast.LENGTH_LONG);
            toast0.show();
            mi_Visor_Web.reload();
            swipe_Layaout.setRefreshing(false);
        }
    };

}
