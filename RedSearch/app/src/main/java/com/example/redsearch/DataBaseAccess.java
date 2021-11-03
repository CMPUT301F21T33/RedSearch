package com.example.redsearch;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;

public class DataBaseAccess {
    final String TAG = "Sample";
    FirebaseFirestore db;
    CollectionReference collectionReference;

    public DataBaseAccess(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        collectionReference = db.collection("Users");
    }

    public void data_Insert(String Username, String habitName, String habitData){
        HashMap<String, String> inputData = new HashMap<>();
        inputData.put(habitName,habitData);
        collectionReference.document(Username).set(inputData,SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                // These are a method which gets executed when the task is succeeded
                Log.d(TAG, "Data has been added successfully!");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // These are a method which gets executed if there’s any problem
                        Log.d(TAG, "Data could not be added!" + e.toString());
                    }
                });
    }


}
