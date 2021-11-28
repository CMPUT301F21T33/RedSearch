package com.example.redsearch;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that can be instantiated that creates simplified methods of adding and removing data from
 * the database
 */
public class DataBaseAccess {
    final String TAG = "Sample";
    FirebaseFirestore db;
    CollectionReference collectionReference;

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
     * After having a Username and password inputted it will check with the remote database to see if the
     * password data is accurate and return true or false based upon if the inputted password matches that which is stored in
     * the remote database
     * @param Username The users username
     * @param Password The users password
     * @return
     */
    public Boolean PassCheck (String Username, String Password){
        Boolean check = true;
        String dataPass = null;
        int count = 0;
        while(check){
            DocumentReference docRef = db.collection("Users").document(Username);
            try {
                Task<DocumentSnapshot> data = docRef.get();
                dataPass = (String) data.getResult().getData().get("Password");
                check =  false;
            }catch(Exception e){
                count++;
                if(count > 200){
                    check = false;
                    return false;
                }
                check = true;
            }
        }
        if(dataPass.equals(Password)){
            return true;
        }
        return false;
    }

    /**
     * This method retrieves an ArrayList<Habit> from the remote database, this retrieval does not include
     * the users password.
     * @param Username The user we are retrieving data from
     * @param returnData an inputted array that gets CLEARED before any new data is pushed into it from
     *                   the remote database
     * @return true if data was successfully retrieved
     */
    public Boolean returnHabits(String Username, ArrayList<Habit> returnData){
        returnData.clear();
        DocumentReference docRef = db.collection("Users").document(Username);
        Task<DocumentSnapshot> data;
        Map<String, Object> retrievedData;

        Boolean check = true;
        while(check){
            try {
                data = docRef.get();
            }catch(Exception IllegalStateException){
                Log.d(TAG, "Error has occurred in accessing Database: " + IllegalStateException);
                return false;
            }
            int count = 0;
            while(true) {
                try {
                    retrievedData = data.getResult().getData();
                    break;
                } catch (Exception IllegalStateException) {
                    count++;
                    if (count > 200) {
                        Log.d(TAG, "Error has occurred in accessing Database: " + IllegalStateException);
                        return false;
                    }
                }
            }
            for(String key: retrievedData.keySet()){
                if(key.equals("Password") || key.equals("Followers") || key.equals("Follower_requests") || key.equals("Following")){
                    continue;
                }
                Object habitData = retrievedData.get(key);
                HashMap<String, ?> stuff = (HashMap) habitData;
                HashMap<?, ?> hh = (HashMap<?, ?>) stuff.get("habitEventList");
                ArrayList<?> st = (ArrayList<?>) hh.get("habitEventList");
                HabitEventList events = new HabitEventList((ArrayList<HabitEvent>) st);
                Habit habit = new Habit(key,
                        (String) stuff.get("reason"),
                        ((Timestamp) stuff.get("startDate")).toDate(),
                        (int) ((long) stuff.get("daysplanned")),
                        (int) ((long)stuff.get("dayshappened")),
                        (Boolean) stuff.get("visible"),
                        events,
                        (boolean[]) stuff.get("weekday"));
                returnData.add(habit);

            }
            Log.d(TAG, "Data retrieved");
            check = false;
        }
        return true;
    }

    /**
     * Returns an boolean on if the function was successful or not, from there it will populate the returndata array with
     * the values of all Users currently in the database
     * @param returnData A blank array to be populated with usernames
     * @return
     */
    public Boolean returnUsers(ArrayList<String> returnData){
        returnData.clear();
        Task<QuerySnapshot> data;
        int count  =0;

        while(true){
            try {
                data = collectionReference.get();
                for(QueryDocumentSnapshot key: data.getResult()){
                    Log.d(TAG, key.getId() + " => " + key.getString("name"));
                    returnData.add(key.getId());
                }
                return true;
            }catch(Exception IllegalStateException){
                count++;
                if(count > 200){
                    Log.d(TAG, "Database reading has timed out " + IllegalStateException);
                    return false;
                }

            }

        }
    }

    /**
     * Adds a follower to a specfic user
     * @param Username The user we are adding a follower too
     * @param Follower The user who is following
     */
    public void addFollower(String Username, String Follower){
        HashMap<String, ArrayList<String>> inputData = new HashMap<>();
        collectionReference.document(Username).update("Followers", FieldValue.arrayUnion(Follower)).addOnSuccessListener(new OnSuccessListener<Void>() {
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
     * Removes a foloower from a user
     * @param Username The user losing a follower
     * @param Follower The Follower that is leaving
     */
    public void removeFollower(String Username, String Follower){
        HashMap<String, ArrayList<String>> inputData = new HashMap<>();
        collectionReference.document(Username).update("Followers", FieldValue.arrayRemove(Follower)).addOnSuccessListener(new OnSuccessListener<Void>() {
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
     * Returns the whole list of followers that is following said user
     * @param Username The user with the followers
     * @param returnData A blank array that is filled with the return data
     * @return A true if data was retrieved successfully
     */
    public Boolean returnFollowers(String Username, ArrayList<String> returnData){
        returnData.clear();
        DocumentReference docRef = db.collection("Users").document(Username);
        Task<DocumentSnapshot> data;

        Boolean check = true;
        while(check){
            try {
                data = docRef.get();
            }catch(Exception IllegalStateException){
                Log.d(TAG, "Error has occurred in accessing Database: " + IllegalStateException);
                return false;
            }
            Map<String, Object> retrievedData = data.getResult().getData();
            returnData = (ArrayList<String>) retrievedData.get("Followers");
            Log.d(TAG, "Data retrieved");
            check = false;
        }
        return true;
    }

    /**
     * Adds a user that requests to follow
     * @param Username The user that has the request
     * @param Follower The person requesting a follow
     */
    public void addFollowerRequest(String Username, String Follower){
        HashMap<String, ArrayList<String>> inputData = new HashMap<>();
        collectionReference.document(Username).update("Follower_requests", FieldValue.arrayUnion(Follower)).addOnSuccessListener(new OnSuccessListener<Void>() {
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
     * Removes a follower request
     * @param Username The user declining the request
     * @param Follower  The user being declined the request
     */
    public void removeFollowerRequest(String Username, String Follower){
        HashMap<String, ArrayList<String>> inputData = new HashMap<>();
        collectionReference.document(Username).update("Follower_requests", FieldValue.arrayRemove(Follower)).addOnSuccessListener(new OnSuccessListener<Void>() {
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
     * Returns a array of follower requests
     * @param Username User with the requests
     * @param returnData The lists of requests
     * @return True if data was retrieved properly
     */
    public Boolean returnFollowerRequests(String Username, ArrayList<String> returnData){
        returnData.clear();
        DocumentReference docRef = db.collection("Users").document(Username);
        Task<DocumentSnapshot> data;

        Boolean check = true;
        while(check){
            try {
                data = docRef.get();
            }catch(Exception IllegalStateException){
                Log.d(TAG, "Error has occurred in accessing Database: " + IllegalStateException);
                return false;
            }
            Map<String, Object> retrievedData = data.getResult().getData();
            returnData = (ArrayList<String>) retrievedData.get("Follower_requests");
            Log.d(TAG, "Data retrieved");
            check = false;
        }
        return true;
    }

    /**
     * Adds a account to the following list
     * @param Username The user to be following
     * @param Following The user who is now being followed
     */
    public void addFollowing(String Username, String Following){
        HashMap<String, ArrayList<String>> inputData = new HashMap<>();
        collectionReference.document(Username).update("Following", FieldValue.arrayUnion(Following)).addOnSuccessListener(new OnSuccessListener<Void>() {
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
     * Removes The user you are following
     * @param Username The user removing the follow
     * @param Following the user to be removed
     */
    public void removeFollowing(String Username, String Following){
        HashMap<String, ArrayList<String>> inputData = new HashMap<>();
        collectionReference.document(Username).update("Following", FieldValue.arrayRemove(Following)).addOnSuccessListener(new OnSuccessListener<Void>() {
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

    public Boolean returnFollowing(String Username, ArrayList<String> returnData){
        returnData.clear();
        DocumentReference docRef = db.collection("Users").document(Username);
        Task<DocumentSnapshot> data;

        Boolean check = true;
        while(check){
            try {
                data = docRef.get();
            }catch(Exception IllegalStateException){
                Log.d(TAG, "Error has occurred in accessing Database: " + IllegalStateException);
                return false;
            }
            Map<String, Object> retrievedData = data.getResult().getData();
            returnData = (ArrayList<String>) retrievedData.get("Following");
            Log.d(TAG, "Data retrieved");
            check = false;
        }
        return true;
    }

}
