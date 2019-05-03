package com.example.firebasestorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name,email,collage,number;
    Button save,show;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("user");

        // Write a message to the database
      /*  FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");*/


        name = findViewById(R.id.nameEditText);
        email = findViewById(R.id.emaileditText);
        collage = findViewById(R.id.collageEditText);
        number = findViewById(R.id.numberEditText);
        save = findViewById(R.id.saveButton);
        show = findViewById(R.id.loadData);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storAllData();
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                startActivity(intent);
            }
        });


    }

    public void  storAllData(){
        String userName = name.getText().toString().trim();
        String userEmail = email.getText().toString().trim();
        String userCollage = collage.getText().toString().trim();
        String userNumber = number.getText().toString().trim();


        String key = databaseReference.push().getKey();

        UserDetails userDetails = new UserDetails(userName,userEmail,userCollage,userNumber);
        databaseReference.child(key).setValue(userDetails);
        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();

        name.setText("");
        email.setText("");
        collage.setText("");
        number.setText("+8801");



    }
}
