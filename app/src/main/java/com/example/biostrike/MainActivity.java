package com.example.biostrike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),HomescreenActivity.class);
                startActivity(intent);
            }
        });
    }

    public Connection connectionclass(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURl = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURl = "jdbc:sqlserver://advancingtechnoloiges1.database.windows.net:1433;database=ATLETECHS DATABASE;user=ralphonse@advancingtechnoloiges1;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection = DriverManager.getConnection(connectionURl);
        }
        catch (SQLException se) {
            Log.e("error here 1" , se.getMessage());
        }
        catch (ClassNotFoundException e) {
            Log.e("error here 1" , e.getMessage());
        }
        catch (Exception e) {
            Log.e("error here 1" , e.getMessage());
        }
        return connection;
    }
}
