package com.example.biostrike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This class is related to Device section of the application. Mostly connect to devices
 * and display all the information related to the devices
 */
public class DeviceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_screen);
        //This adapter list all the possible connected devices
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Device_items,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //This let the user open the drop down menu
        Spinner device1 = findViewById(R.id.device1);
        Spinner device2 = findViewById(R.id.device2);
        Spinner device3 = findViewById(R.id.device3);
        Spinner device4 = findViewById(R.id.device4);

        //This connect the spinners to adapter
        device1.setAdapter(adapter);
        device1.setOnItemSelectedListener(this);
        device2.setAdapter(adapter);
        device2.setOnItemSelectedListener(this);
        device3.setAdapter(adapter);
        device3.setOnItemSelectedListener(this);
        device4.setAdapter(adapter);
        device4.setOnItemSelectedListener(this);


        //When pressed, will navigate to home
        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomescreenActivity.class);
                startActivity(intent);
            }
        });

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

        //When pressed, will apply all the setting changed in the goal screen
        Button applyButton = (Button) findViewById(R.id.applyButton);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),HomescreenActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
