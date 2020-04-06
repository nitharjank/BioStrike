package com.example.biostrike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class DeviceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_screen);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Device_items,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner device1 = findViewById(R.id.device1);
        Spinner device2 = findViewById(R.id.device2);
        Spinner device3 = findViewById(R.id.device3);
        Spinner device4 = findViewById(R.id.device4);

        device1.setAdapter(adapter);
        device1.setOnItemSelectedListener(this);
        device2.setAdapter(adapter);
        device2.setOnItemSelectedListener(this);
        device3.setAdapter(adapter);
        device3.setOnItemSelectedListener(this);
        device4.setAdapter(adapter);
        device4.setOnItemSelectedListener(this);



        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomescreenActivity.class);
                startActivity(intent);
            }
        });


        Button currButton = (Button) findViewById(R.id.currentButton);
        currButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CurrentActivity.class);
                startActivity(intent);
            }
        });

        Button pastButton = (Button) findViewById(R.id.pastButton);
        pastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PastActivity.class);
                startActivity(intent);
            }
        });
        Button goalsButton = (Button) findViewById(R.id.goalsButton);
        goalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),GoalsActivity.class);
                startActivity(intent);
            }
        });


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
