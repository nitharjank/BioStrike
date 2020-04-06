package com.example.biostrike;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.os.Handler;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import android.widget.ImageView;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CurrentActivity extends AppCompatActivity {
    TextView textView ;
    Button start, pause, reset;
    Handler handler;
    int Seconds, Minutes, MilliSeconds ;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;
    String[] ListElements = new String[] {  };
    List<String> ListElementsArrayList ;
    ArrayAdapter<String> adapter ;
    ImageView image;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_screen);

        textView = (TextView)findViewById(R.id.time);
        start = (Button)findViewById(R.id.startbutton);
        pause = (Button)findViewById(R.id.pausebutton);
        reset = (Button)findViewById(R.id.resetbutton);
        image = (ImageView) findViewById(R.id.imageView1);

        handler = new Handler() ;

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));
        adapter = new ArrayAdapter<String>(CurrentActivity.this,
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                reset.setEnabled(false);

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                reset.setEnabled(true);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;

                textView.setText("TIMER: 00:00:00");

                ListElementsArrayList.clear();

                adapter.notifyDataSetChanged();
            }
        });
        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomescreenActivity.class);
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

    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            textView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };
}
