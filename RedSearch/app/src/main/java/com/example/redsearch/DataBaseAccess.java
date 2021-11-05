package com.example.redsearch;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;

/**
 * A class that can be instantiated that creates simplified methods of adding and removing data from
 * the database
 */
public class DataBaseAccess {
    private final String TAG = "Sample";
    private FirebaseFirestore db;
    private CollectionReference collectionReference;
    private DocumentSnapshot doc;
    private Boolean check;

    /**
     * A constructor that must be called to allow any other class to use
     * the required database
     */
    public DataBaseAccess(){
        db = FirebaseFirestore.getInstance();
        collectionReference = db.collection("Users");
    }

    /**
     * THis function takes in three string inputs and adds the last string into a field
     * named based upon the second string under the document named by the first string
     * @param Username Name of the User we are inputting data for
     * @param habitName Name of the Habit to be added into the data may also be the string "Password"
     *                  to indicate a password insertion
     * @param habitData All other relevant data for the insertion
     */
    public void dataInsert(String Username, String habitName, String habitData){
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

    /**
     * A modified version of the above insert that allows a habit object to be inserted
     * @param Username the users username
     * @param habitName a name for the habit object to be inserted
     * @param habitData The habit object to be added
     */
    public void dataInsert(String Username, String habitName, Habit habitData){
        HashMap<String, Habit> inputData = new HashMap<>();
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

    /**
     * Deletes a specific habit from a specific User
     * @param Username The user
     * @param habitName The habit to be deleted
     */
    public void dataRemove(String Username, String habitName){
        HashMap<String, Object> removalData = new HashMap<>();
        removalData.put(habitName, FieldValue.delete());
        collectionReference.document(Username).update(removalData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                // These are a method which gets executed when the task is succeeded
                Log.d(TAG, "Data has been removed successfully!");

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // These are a method which gets executed if there’s any problem
                        Log.d(TAG, "Data could not be removed" + e.toString());
                    }
                });
    }

    /**
     * Creates a listener that will realtime update with changes to the database
     * @param Username
     */
    public void createListener(String Username){
        final DocumentReference docRef = db.collection("Users").document(Username);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    Log.d(TAG, "Current data: " + snapshot.getData());
                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });

    }

    /**
     * TODO: This function is suppose to verify that a entered passsword exists in the database
     * Currently it does not work
     * @param Username
     * @param Password
     * @return
     */
    public Boolean PassCheck (String Username, String Password){
        check = false;
        DocumentReference docRef = collectionReference.document(Username);
        Task data = docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    String passData = (String) document.get("Password");
                    passData = passData.trim();
                    if(passData.equals(Password) == true){
                        check = true;
                    }
                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        });
        System.out.println("Test");
        return check;
    }





}
