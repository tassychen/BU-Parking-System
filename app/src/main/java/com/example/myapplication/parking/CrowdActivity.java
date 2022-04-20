package com.example.myapplication.parking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;


public class CrowdActivity extends AppCompatActivity {
    private RadioGroup crowdGroup;
    private RadioButton crowdButton;
    private Button submit;
    private String crowd;
    Connection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crowd);
        crowdGroup =(RadioGroup)findViewById(R.id.radioGroup);

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = crowdGroup.getCheckedRadioButtonId();
                crowdButton = (RadioButton)findViewById(selectedId);
                crowd = (String) crowdButton.getText();
            }
        });

        ConnectSQL("PLACEHOLDER", crowd);
    }

    public void ConnectSQL(String lot, String crowd){
        String HOST = "jdbc:mysql://127.0.0.1:3306/buparking";
        String DATABASE = "parking";
        String USER = "root";
        String PASSWORD = "2308iNg120Ka19";
        Date date = new Date();
        Time time = new Time(date.getTime());
        try {
            conn = DriverManager.getConnection(HOST, USER, PASSWORD);
            PreparedStatement statement = ((java.sql.Connection) conn).prepareStatement("INSERT INTO lot VALUES (?,?,?,?,?)");
            statement.setNull(1, 1);
            statement.setString(2,"Langsam");
            statement.setTime(3, time);
            statement.setInt(4, 5);
            statement.setString(5, "almost full");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}