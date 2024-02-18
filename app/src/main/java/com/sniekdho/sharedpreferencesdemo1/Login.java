package com.sniekdho.sharedpreferencesdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText logEmailET, logPasswordET;
    private Button loginBTN, openRegisterBTN;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logEmailET = findViewById(R.id.logEmailET);
        logPasswordET = findViewById(R.id.logPasswordET);

        loginBTN = findViewById(R.id.loginBTN);
        openRegisterBTN = findViewById(R.id.openRegisterBTN);

        sessionManager = new SessionManager(Login.this);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = logEmailET.getText().toString();
                String password = logPasswordET.getText().toString();

                if (email.equals("test@gmail.com") && password.equals("test12345"))
                {
                    sessionManager.createSession("Test", "test@gmail.com", "female");

                    startActivity(new Intent(Login.this, Profile.class));
                }
                else
                {
                    Toast.makeText(Login.this, "Email and Password didn't matched!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        openRegisterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this, Register.class));

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}