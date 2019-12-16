package com.moringa.tracks;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.tracks.Models.Users;

import java.text.DateFormat;
import java.util.Calendar;

public class Attendance extends AppCompatActivity {
RadioGroup radioGroup;
RadioButton radioBtn;
    RadioButton radioBtn3;
    RadioButton radioBtn2;
Button button;
DatabaseReference databaseRadio;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        databaseRadio= FirebaseDatabase.getInstance().getReference("radio");

Calendar calendar = Calendar.getInstance();
String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

TextView textViewDate = findViewById(R.id.text_text_date);
textViewDate.setText(currentDate);
        SharedPreferences mySharedPreferences = getSharedPreferences("com.moringa.tracks", Context.MODE_PRIVATE);
         username= mySharedPreferences.getString("username", "");
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        button = (Button) findViewById(R.id.button);
        radioBtn2 =(RadioButton)findViewById(R.id.absent);
        radioBtn =(RadioButton)findViewById(R.id.radio_late);
    }
    public void onRadioButtonClicked(View view){

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int rgs_id = radioGroup.getCheckedRadioButtonId();
                radioBtn3 =(RadioButton)findViewById(rgs_id);
                String presence=radioBtn3.getText().toString();
                System.out.println(presence);
                Users user=new Users(username,presence);
                String data=databaseRadio.push().getKey();
                databaseRadio.child(data).setValue(user);
            }
        });


        radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users user=new Users(username,"late");
                String data=databaseRadio.push().getKey();
                databaseRadio.child(data).setValue(user);

                Intent intent = new Intent(Attendance.this,AttendanceForm.class);
                startActivity(intent);
}
    });
        radioBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users user=new Users(username,"absent");
                String data=databaseRadio.push().getKey();
                databaseRadio.child(data).setValue(user);

                Intent intent = new Intent(Attendance.this,AttendanceForm.class);
                startActivity(intent);
            }
        });

}
}