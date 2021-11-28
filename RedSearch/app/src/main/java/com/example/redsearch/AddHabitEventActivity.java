// Acknowledgement: https://www.geeksforgeeks.org/android-how-to-upload-an-image-on-firebase-storage/
// https://www.geeksforgeeks.org/android-how-to-open-camera-through-intent-and-display-captured-image/

package com.example.redsearch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import org.osmdroid.util.GeoPoint;

import java.io.IOException;
import java.util.Date;

/**
 * This is the AddHabitEventActivity that is used to add a habit event
 */

public class AddHabitEventActivity extends AppCompatActivity implements SelectLocation.OnFragmentInteractionListener {

    private final int PICK_IMAGE_REQUEST = 141;
    private final int CAMERA_IMAGE_REQUEST = 232;
    private Uri filePath;
    private ImageView habitImage;
    private Bitmap bitmap = null;
    private GeoPoint point = null;
    private String user;
    private String habit;

    /**
     * To run at the start of the activity
     * @param savedInstanceState {@code Bundle}
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit_event);

        // Get the Username and Habit name from the previous activity
        //Intent intent = getIntent();
        //user = intent.getStringExtra("USER");
        //habit = intent.getStringExtra("HABIT");

        Toolbar toolbar = findViewById(R.id.toolbar_add_habit_event);
        setSupportActionBar(toolbar);
        setTitle("Log Habit");

        habitImage = findViewById(R.id.habitImage);  // Initialize the habit event image
    }

    /**
     * Action for if an image is requested for habit event
     * @param requestCode {@code int} The request code number for desired outcome
     * @param resultCode {@code int} Result code
     * @param data {@code data} The intent data
     */
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        /* Checking request code and result code
            if request code is PICK_IMAGE_REQUEST and resultCode is RESULT_OK then set
            image in the image view
         */
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                habitImage.setImageBitmap(bitmap);

            } catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }

        // Check the request code for using the camera to take an image
        if (requestCode == CAMERA_IMAGE_REQUEST
                && resultCode == RESULT_OK) {

            // Get the image and display it
            bitmap = (Bitmap) data.getExtras().get("data");
            habitImage.setImageBitmap(bitmap);
        }
    }

    /**
     * Access an uploaded image for habit event
     * @param view {@code View}
     */
    public void uploadImage(View view) {
        // Defining Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        // Get image from the mobile gallery
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    public void cameraImage(View view) {
        // Create the camera_intent ACTION_IMAGE_CAPTURE
        // it will open the camera for capture the image
        Intent camera_intent
                = new Intent(MediaStore
                .ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera_intent, CAMERA_IMAGE_REQUEST);
    }

    /**
     * Open the map for geolocation
     * @param view {@code View}
     */
    public void openMap(View view) {
        Bundle bundle = new Bundle();
        DialogFragment fragment = new SelectLocation();

        // Get latitude and longtitude
        if (point != null){
            bundle.putDouble("LATITUDE", point.getLatitude());
            bundle.putDouble("LONGTITUDE", point.getLongitude());
        }
        fragment.setArguments(bundle);
        fragment.show(getSupportFragmentManager(), "Select Location");
    }

    /**
     * Save habit event and return to the previous page
     * @param view {@code View}
     */
    public void goToHome(View view) {

        // Get the comment for the habit event
        EditText comment = findViewById(R.id.Comment);
        Date date = new Date();  // Get a date object
        HabitEvent newHabitEvent;  // Initialize a habit event object to be filled

        // If we have a picture and a geolocation use, that constructor
        if (bitmap != null && point != null) {
            newHabitEvent = new HabitEvent(comment.getText().toString(), date, point, bitmap);
        } else if (bitmap != null) {  // We only have an image for the habit event
            newHabitEvent = new HabitEvent(comment.getText().toString(), date, bitmap);
        } else if (point != null) {  // We only have a geolocation for the habit event
            newHabitEvent = new HabitEvent(comment.getText().toString(), date, point);
        } else {  // No geolocation or image for habit event
            newHabitEvent = new HabitEvent(comment.getText().toString(), date);
        }

        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("HabitDone", "Done");
        startActivity(intent);

    }

    /**
     * Go to the home page without logging a habit event
     * @param view {@code View}
     */
    public void goHomeCancelEvent(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    /**
     * Returns the selected location via GeoPoint
     * @param newPoint {@code GeoPoint} returns the selected location via a GeoPoint
     */
    @Override
    public void onOkPressed(GeoPoint newPoint){
        point = newPoint;
        TextView coordinates  = findViewById(R.id.coordinates);
        coordinates.setText(point.toDoubleString());
    }
}

