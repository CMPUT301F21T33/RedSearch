package com.example.redsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        setTitle("Today's Habits");
        //Get the username from the previous one

        Intent intent = getIntent();
        // This is the username that the user gave in the login activity
        String username = intent.getStringExtra(MainActivity.USERNAME);
        username = "TEST";

        ListView list = (ListView) findViewById(R.id.listView);

        DataBaseAccess db = new DataBaseAccess();


        // TEMP STUFF
        Date date = new Date();
        Habit thing = new Habit("Title", "For cars", new Date(), true);
        thing.getHabitEventList().addHabitEvent(new HabitEvent("thing", date));
        db.dataInsert("TEST", thing.getTitle(), thing);
        // TEMP ENDS HERE
        ArrayList<Habit> allHabits = new ArrayList<Habit>();

        Habit thing2 = new Habit("drink water", "do it", new Date(), true);
        thing.setWeekday(6);
        Habit other = new Habit("other thing", "dont do it", new Date(), false);
        other.setWeekday(3);
        allHabits.add(thing);
        allHabits.add(other);

        while(!db.returnHabits("TEST", allHabits));  // TODO time out checker
        ArrayList<Habit> todayHabits = getTodayHabits(allHabits);
        //todayHabits.add(new Habit("Drink water","I am thirsty",new Date(),true));

        HabitListAdapter adapter = new HabitListAdapter(this,todayHabits);
        list.setAdapter(adapter);*/

        String finalUsername = username;
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), AddHabitEventActivity.class);
                intent.putExtra("USER", finalUsername);
                //intent.putExtra("HABIT", )
                startActivity(intent);
            }
        });


    }

    private ArrayList<Habit> getTodayHabits(ArrayList<Habit> allHabits) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        ArrayList<Habit> todayHabits = new ArrayList<Habit>();
        int today = Calendar.DAY_OF_WEEK - 1;
        System.out.println(today);
        for (int i = 0; i < allHabits.size(); i++) {

            /*
            if (allHabits.get(i).getWeekday(today)) {
                todayHabits.add(allHabits.get(i));
            }
             */
        }
        return todayHabits;
    }

    /**
     * This moves to the MyHabitsActivity when the ViewAll button is pressed
     * @param view {@code View} takes in the view
     */
    public void goToMyHabits(View view) {
        Intent intent = new Intent(this, MyHabitsActivity.class);
        startActivity(intent);
    }

    public void goToFriends(View view) {
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }

    public void goToHabitEventList(View view) {
        Intent intent = new Intent(this, HabitEventListActivity.class);
        startActivity(intent);
    }

    /**
     * This moves to the FriendsActivity when the friendsButton is pressed
     * @param view {@code View} takes in the view
     */
    public void goToMyFriends(View view) {
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }
}
