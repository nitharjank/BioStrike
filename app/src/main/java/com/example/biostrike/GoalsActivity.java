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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        temp = new ArrayList<>();

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

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ConnectionClass con = new ConnectionClass();
//                Connection connect = ConnectionClass.CONN();
//                try {
//                    Statement stmt = connect.createStatement();
//                    ResultSet rs;
//                    rs = stmt.executeQuery("SELECT goal FROM BioStrike_Table WHERE userName = "+MainActivity.user_name);
//                    Log.d("Name", "I am here");
//                    while (rs.next()){
//                        temp.add(rs.getString("goal"));
//                    }
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//
//                    }
//        }).start();
        temp.add("Need to improve the force of punch");
        temp.add("Need to improve speed of the punch");
        temp.add("Have to talk to my coach tomorrow");
        Log.d("Array", temp.size()+"");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, temp);

        View.OnClickListener addList = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp.add(textView.getText().toString());
                String goal = textView.getText().toString();
                String user = MainActivity.user_name;
                try {
                    ConnectionClass con = new ConnectionClass();
                    Connection connect = ConnectionClass.CONN();
                    String queryStmt = "Insert into BioStrike_Goal values "
                            + "('" + user
                            + "','" + goal
                            +"')";

                    PreparedStatement preparedStatement = connect
                            .prepareStatement(queryStmt);

                    preparedStatement.executeUpdate();

                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Exception. Please check your code and database.");
                }
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
