package com.sniekdho.sharedpreferencesdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView userNameTV, userEmailTV, userGenderTV;
    private Button logoutBTN;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userNameTV = findViewById(R.id.userNameTV);
        userEmailTV = findViewById(R.id.userEmailTV);
        userGenderTV = findViewById(R.id.userGenderTV);

        logoutBTN = findViewById(R.id.logoutBTN);

        sessionManager = new SessionManager(this);

        String name = sessionManager.getSessionDetails("key_session_name");
        String email = sessionManager.getSessionDetails("key_session_email");
        String gender = sessionManager.getSessionDetails("key_session_gender");

        userNameTV.setText(name);
        userEmailTV.setText(email);
        userGenderTV.setText(gender);

        logoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutSession();
                finish();
            }
        });
    }
}