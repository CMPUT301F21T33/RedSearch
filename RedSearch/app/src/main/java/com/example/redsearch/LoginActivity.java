package com.example.redsearch;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    Button signinButton;
    Button signupButton;
    EditText username;
    EditText password;
    TextView userError;
    TextView passwordError;
    DataBaseAccess db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signinButton = findViewById(R.id.signIn);
        signupButton = findViewById(R.id.signUp);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        userError = findViewById(R.id.userError);
        passwordError = findViewById(R.id.passwordError);
        db = new DataBaseAccess();
        userError.setText("Hello");
        passwordError.setText("Goodbye");
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }







}





