package com.example.rohkudus;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.EventLogTags;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true )
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent homeIntent = new Intent(MainActivity.this, Home2Activity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }, SPLASH_TIME_OUT);

        } else {
            Toast.makeText(MainActivity.this, "Jaringan internet tidak tersedia, mohon mengaktifkan koneksi internet", Toast.LENGTH_LONG).show();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    System.exit(0);
                    finish();
                }
            }, 3500);
        }
    }
}
