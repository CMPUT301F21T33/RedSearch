/**
 * CMPUT 301 FALL 2021
 * RedSearch Project
 * @author
 *
 * The {@code ViewHabitEventActivity} Class
 *
 * Activity for ViewHabitEvent.
 *
 * Copyright 2021
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Acknowledgements:
 * N/A
 * */

package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ViewHabitEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_habit_event);
    }
}