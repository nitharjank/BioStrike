package com.example.biostrike;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GoalsActivity extends AppCompatActivity {


    ArrayAdapter<String> adapter;
    ArrayList<String> temp;
    TextView textView;
    ListView list;
    Button addButton;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals_screen);


        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomescreenActivity.class);
                startActivity(intent);
            }
        });


        textView = (TextView) findViewById(R.id.goalsText);
        addButton = (Button) findViewById(R.id.addButton);
        list = (ListView) findViewById(R.id.menu);
        temp = new ArrayList<>();
        temp.add("Need to improve the force of punch");
        temp.add("Need to improve speed of the punch");
        temp.add("Have to talk to my couch tomorrow");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, temp);

        View.OnClickListener addList = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp.add(textView.getText().toString());
                adapter.notifyDataSetChanged();
                textView.setText("");
            }
        };


        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray pos = list.getCheckedItemPositions();

                int count = list.getCount();

                for (int i = count -1; i >= 0; i--) {
                    if (pos.get(i)){
                        adapter.remove(temp.get(i));
                    }
                }

                pos.clear();


                return false;
            }
        });

        addButton.setOnClickListener(addList);
        list.setAdapter(adapter);

    }

    public void addToList(View view) {

        temp.add(textView.getText().toString());
        adapter.notifyDataSetChanged();
        // Clear the input
        textView.setText("");

    }
}
