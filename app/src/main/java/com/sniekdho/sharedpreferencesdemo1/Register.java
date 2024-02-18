package com.sniekdho.sharedpreferencesdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Register extends AppCompatActivity {

    private EditText regNameET, regEmailET, regPasswordET;
    private RadioGroup genderRG;
    private String gender = "Male";
    private Button registerBTN, openLoginBTN;

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regNameET = findViewById(R.id.regNameET);
        regEmailET = findViewById(R.id.regEmailET);
        regPasswordET = findViewById(R.id.regPasswordET);

        genderRG = findViewById(R.id.genderRG);

        registerBTN = findViewById(R.id.registerBTN);
        openLoginBTN = findViewById(R.id.openLoginBTN);

        sessionManager = new SessionManager(this);

        genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radioButton = findViewById(checkedId);
                gender = radioButton.getText().toString();

            }
        });

        registerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = regNameET.getText().toString();
                String email = regEmailET.getText().toString();
                String password = regPasswordET.getText().toString();

                //insert into mysql database ------------------

                sessionManager.createSession(name, email, gender);

                startActivity(new Intent(Register.this, Profile.class));

            }
        });

        openLoginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Register.this, Login.class));

            }
        });
    }
}