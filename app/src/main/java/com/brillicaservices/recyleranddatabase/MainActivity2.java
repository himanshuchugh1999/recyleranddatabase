package com.brillicaservices.recyleranddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HIMANSHU CHUGH on 12-07-2018.
 */

public class MainActivity2 extends AppCompatActivity {
    EditText namevalue,addressvalue,phonevalue;
    Button b1,b2;
    ArrayList<Student> studentClassArrayList = new ArrayList();
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        String name,address;
        long phone;
        namevalue=findViewById(R.id.name);
        addressvalue=findViewById(R.id.address);
        phonevalue=findViewById(R.id.phonenumber);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        databaseHelper=new DatabaseHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,address;
                long phone;
                 name = namevalue.getText().toString();
                 address = addressvalue.getText().toString();
                 phone = Long.parseLong(phonevalue.getText().toString());
                databaseHelper.addNewStudent(new Student(name, phone,address));
                Toast.makeText(getApplicationContext(),
                        "Student data saved successfully",
                        Toast.LENGTH_LONG).show();
                studentClassArrayList.addAll(databaseHelper.allStudentsDetails());
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity2.this,activity33.class);
                startActivity(intent1);
            }
        });

    }
}
