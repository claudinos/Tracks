package com.moringa.tracks;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class Attendance extends AppCompatActivity {
RadioGroup radioGroup;
RadioButton radioBtn;
Button button;
DatabaseReference databaseRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        databaseRadio= FirebaseDatabase.getInstance().getReference("radio");

Calendar calendar = Calendar.getInstance();
String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

TextView textViewDate = findViewById(R.id.text_text_date);
textViewDate.setText(currentDate);

        radioGroup = (RadioGroup) findViewById(R.id.radio);
        button = (Button) findViewById(R.id.button);
        radioBtn =(RadioButton)findViewById(R.id.absent);
        radioBtn =(RadioButton)findViewById(R.id.radio_late);
    }
    public void onRadioButtonClicked(View view){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rgs_id = radioGroup.getCheckedRadioButtonId();
                radioBtn =(RadioButton)findViewById(rgs_id);
                String name=radioBtn.getText().toString();
                System.out.println(name);
                String data=databaseRadio.push().getKey();
                databaseRadio.child(data).setValue(name);
            }
        });


        radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Attendance.this,AttendanceForm.class);
                startActivity(intent);
}
    });

}
}