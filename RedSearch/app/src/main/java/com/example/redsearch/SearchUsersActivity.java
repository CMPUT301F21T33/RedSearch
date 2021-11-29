package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchUsersActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    DataBaseAccess db = new DataBaseAccess();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_users);

        Toolbar toolbar = findViewById(R.id.toolbar_search_users);
        setSupportActionBar(toolbar);
        setTitle("Search Users");

        EditText editText = (EditText) findViewById(R.id.editText);
        ListView list = (ListView) findViewById(R.id.listView);

        ArrayList<String> usernames = new ArrayList<>();

        while(!db.returnUsers(usernames)){}


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usernames);

        list.setAdapter(adapter);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (SearchUsersActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Intent intent = getIntent();
                String username = intent.getStringExtra(MainActivity.USERNAME);*/
                db.addFollowerRequest("Sam","Lauren");


            }
        });

    }
}