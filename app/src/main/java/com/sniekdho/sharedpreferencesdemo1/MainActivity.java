package com.sniekdho.sharedpreferencesdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                sessionManager = new SessionManager(MainActivity.this);
                boolean b = sessionManager.checkSession();
                if (b)
                {
                    startActivity(new Intent(MainActivity.this, Profile.class));
                }
                else
                {
                    startActivity(new Intent(MainActivity.this, Login.class));
                }

            }
        }, 2000);

    }
}