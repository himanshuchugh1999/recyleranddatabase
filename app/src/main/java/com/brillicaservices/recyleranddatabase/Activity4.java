package com.brillicaservices.recyleranddatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HIMANSHU CHUGH on 13-07-2018.
 */

public class Activity4 extends AppCompatActivity {
    TextView n,a,p;
    Student student4;
    DatabaseHelper databaseHelper4;
    ArrayList<Student> studentModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        n=findViewById(R.id.name_ac);
        a=findViewById(R.id.address_ac);
        p=findViewById(R.id.number_ac);
        databaseHelper4 = new DatabaseHelper(this);
        studentModelArrayList.addAll(databaseHelper4.allStudentsDetails());
        n.setText(getIntent().getStringExtra("NAME"));
       a.setText(getIntent().getStringExtra("ADDRESS"));
//       p.setText(getIntent().getStringExtra("NAME"));
}}
