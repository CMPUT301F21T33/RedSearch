package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button signinButton;
    Button signupButton;
    EditText username;
    EditText password;
    TextView userError;
    TextView passwordError;
    public static final String USERNAME = "com.example.redsearch.USERNAME";
    DataBaseAccess db = new DataBaseAccess();
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


    }

    /*
    * When the user clicks Sign In they will be taken to the home page after ensuring that both of the fields  username and password are filled
     */


    public void signinclick(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        // Get the Input
        userError.setText("");
        passwordError.setText("");
        String usernameinput = username.getText().toString();
        String passwordinput = password.getText().toString();
        Boolean goodinput = true;
        Boolean userTrue = true;
        Boolean passwordTrue = true;
        //Verify the input is not empty
        // If user is empty print error user does not exist
        if (usernameinput.isEmpty()) {
            userError.setText("Error User field is empty");
            goodinput = false;
        }
        // If password is empty print error password does not exist
        if (passwordinput.isEmpty()) {
            passwordError.setText("Error password field is empty");
            goodinput = false;
        }

        if (goodinput) {
            //Query the database for the username
            // Call the query command that Justin is making !!!!
            //If returns false
            userError.setText("Error username does not exist");
            // if(not false from above){
            // query the database with the username and the password
            // if false
            passwordError.setText("Error password does not match username");
        }
        if (userTrue && passwordTrue) {
            //Set the User as the username and then move into the home activity
            intent.putExtra(USERNAME, usernameinput);
            startActivity(intent);
        }
    }

    public void signupclick(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        // Get the input
        userError.setText("");
        passwordError.setText("");
        String usernameinput = username.getText().toString();
        String passwordinput = password.getText().toString();
        Boolean goodinput = true;
        //Verify the input is not empty
        // If user is empty print error user does not exist
        if (usernameinput.isEmpty()) {
            userError.setText("Error User field is empty");
            goodinput = false;
        }
        // If password is empty print error password does not exist
        if (passwordinput.isEmpty()) {
            passwordError.setText("Error password field is empty");
            goodinput = false;
        }
        if (goodinput) {
            db.dataInsert(usernameinput, "password", passwordinput);
            User newuser = new User(usernameinput, passwordinput);
            intent.putExtra(USERNAME, usernameinput);
            startActivity(intent);

        }
    }
}