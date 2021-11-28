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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit_event);
        Intent intent = getIntent();
        user = intent.getStringExtra("USER");

        Toolbar toolbar = findViewById(R.id.toolbar_add_habit_event);
        setSupportActionBar(toolbar);
        setTitle("Log Habit");

        habitImage = findViewById(R.id.habitImage);

        EditText comment = findViewById(R.id.Comment);
        Date date = new Date();
        date.getDate();
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
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

        if (requestCode == CAMERA_IMAGE_REQUEST
                && resultCode == RESULT_OK) {
            bitmap = (Bitmap) data.getExtras().get("data");
            habitImage.setImageBitmap(bitmap);
        }
    }

    public void uploadImage(View view) {
        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
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

    public void openMap(View view) {
        Bundle bundle = new Bundle();
        DialogFragment fragment = new SelectLocation();
        if (point != null){
            bundle.putDouble("LATITUDE", point.getLatitude());
            bundle.putDouble("LONGTITUDE", point.getLongitude());
        }
        fragment.setArguments(bundle);
        fragment.show(getSupportFragmentManager(), "Select Location");
    }

    public void goToHome(View view) {
        EditText comment = findViewById(R.id.Comment);
        Date date = new Date();
        HabitEvent newHabitEvent;
        if (bitmap != null && point != null) {
            newHabitEvent = new HabitEvent(comment.getText().toString(), date, point, bitmap);
        }

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }
    @Override
    public void onOkPressed(GeoPoint newPoint){
        point = newPoint;
        TextView coordinates  = findViewById(R.id.coordinates);
        coordinates.setText(point.toDoubleString());
    }
}

