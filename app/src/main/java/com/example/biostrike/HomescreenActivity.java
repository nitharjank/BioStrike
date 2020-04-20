package com.example.biostrike;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Callable;

import static com.example.biostrike.MainActivity.firstname;
import static com.example.biostrike.MainActivity.lastname;

/**
 *This screen will welcome the user and will show necessary information for the user.
 * This method get the username and information from the database and display it. It
 * also getting the devices information.
 */
public class HomescreenActivity extends AppCompatActivity {
    TextView name, weight, weight_class, next_op, fight_date;
    TextView right_hand, left_hand, right_leg, left_leg;
    ImageView image;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        //Field where we are display the user information
        name = findViewById(R.id.user_name);
        weight = findViewById(R.id.weight_fill);
        weight_class = findViewById(R.id.weightc_fill);
        next_op = findViewById(R.id.NextOpp_fill);
        fight_date = findViewById(R.id.Date_fill);

        //These feild will be used for connection of the deices
        right_hand = findViewById(R.id.connected1);
        left_hand = findViewById(R.id.connected2);
        right_leg = findViewById(R.id.connected3);
        left_leg = findViewById(R.id.connected4);
        image = findViewById(R.id.imageView);
        image.setImageResource(R.drawable.whitemale);

        String lastname = MainActivity.lastname;
        String firstname = MainActivity.firstname;
        String user_name = MainActivity.user_name;
        Log.d("FName", user_name);
        Log.d("FName", lastname);
        Log.d("FName", firstname);

        String fullname = firstname + " "+ lastname;
        name.setText(fullname);

        //When pressed, will navigate to current screen
        Button currButton = (Button) findViewById(R.id.currentButton);
        currButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CurrentActivity.class);
                startActivity(intent);
            }
        });

        //When pressed, will navigate to past screen
        Button pastButton = (Button) findViewById(R.id.pastButton);
        pastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PastActivity.class);
                startActivity(intent);
            }
        });

        //When pressed, will navigate to goal screen
        Button goalsButton = (Button) findViewById(R.id.goalsButton);
        goalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),GoalsActivity.class);
                startActivity(intent);
            }
        });

        //When pressed, will navigate to device screen
        Button deviceButton = (Button) findViewById(R.id.deviceButton);
        deviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DeviceActivity.class);
                startActivity(intent);
            }
        });
    }
}
