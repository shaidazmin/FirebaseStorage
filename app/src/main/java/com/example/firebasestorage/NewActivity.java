package com.example.firebasestorage;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewActivity extends AppCompatActivity {

    ListView listView;

    DatabaseReference databaseReference;
    List<UserDetails> userDetailsList;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        userDetailsList = new ArrayList<>();
        customAdapter = new CustomAdapter(this, userDetailsList);
        listView = findViewById(R.id.listViewId);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userDetailsList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    UserDetails userDetails = dataSnapshot1.getValue(UserDetails.class);
                    userDetailsList.add(userDetails);
                }
                listView.setAdapter(customAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
