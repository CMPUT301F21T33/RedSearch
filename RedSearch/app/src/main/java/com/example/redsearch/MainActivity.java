package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_login);

=======
<<<<<<< HEAD
        setContentView(R.layout.activity_login);
        DataBaseAccess db = new DataBaseAccess();
        db.dataInsert("TEST", "Habit 3", "I like things");
        db.dataRemove("TEST", "Habit 2");
=======
        setContentView(R.layout.activity_add_habit);
>>>>>>> main
>>>>>>> main
    }

    /*
    * When the user clicks Sign In they will be taken to the home page
     */
    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}