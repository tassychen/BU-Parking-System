package com.example.myapplication.ui.notifications;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> color;
    private final MutableLiveData<String> model;
    private final MutableLiveData<String> make;
    private final MutableLiveData<String> state;
    private final MutableLiveData<String> number;
    private DatabaseReference Database;
    private String userId;

    public NotificationsViewModel() {
        color = new MutableLiveData<>();
        model = new MutableLiveData<>();
        make = new MutableLiveData<>();
        state = new MutableLiveData<>();
        number = new MutableLiveData<>();

        Database = FirebaseDatabase.getInstance().getReference();
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Database.child("user").child(userId).child("vehicle").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    if (task.getResult().exists()) {
                        setColor();
                        setMake();
                        setModel();
                        setState();
                        setNumber();
                    }
                }
            }
        });


    }

    public void setColor(){
        Database.child("user").child(userId).child("vehicle").child("color").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    color.setValue(task.getResult().getValue().toString());
                }
            }
        });
    }
    public void setMake(){
        Database.child("user").child(userId).child("vehicle").child("make").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    make.setValue(task.getResult().getValue().toString());
                }
            }
        });
    }
    public void setModel(){
        Database.child("user").child(userId).child("vehicle").child("model").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    model.setValue(task.getResult().getValue().toString());
                }
            }
        });
    }
    public void setState(){
        Database.child("user").child(userId).child("vehicle").child("state").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    state.setValue(task.getResult().getValue().toString());
                }
            }
        });
    }
    public void setNumber(){
        Database.child("user").child(userId).child("vehicle").child("number").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    number.setValue(task.getResult().getValue().toString());
                }
            }
        });
    }

    public MutableLiveData<String> getColor() {
        return color;
    }

    public MutableLiveData<String> getMake() {
        return make;
    }

    public MutableLiveData<String> getModel() {
        return model;
    }

    public MutableLiveData<String> getNumber() {
        return number;
    }

    public MutableLiveData<String> getState() {
        return state;
    }
}