package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchUsersActivity extends AppCompatActivity {
    private ArrayAdapter adapter;

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
        usernames.add("Laura");
        usernames.add("Max");
        usernames.add("Lauren");
        usernames.add("Lloyd");

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

    }
}