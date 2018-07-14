package com.brillicaservices.recyleranddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HIMANSHU CHUGH on 12-07-2018.
 */

public class activity33  extends AppCompatActivity implements RecylerAdapter.ListItemClickListener{

    RecyclerView recyclerView;

    RecylerAdapter recyclerAdapter;

    DatabaseHelper databaseHelper;

    ArrayList<Student> studentModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        recyclerView = findViewById(R.id.recyclerView1);
        databaseHelper = new DatabaseHelper(this);
        studentModelArrayList.addAll(databaseHelper.allStudentsDetails());

//        studentModelArrayList.add(new Student("Sakshi",1244,"fddf"));
//        studentModelArrayList.add(new Student("Karan",1244,"fddf"));
//        studentModelArrayList.add(new Student("Jayesh",1244,"fddf"));
//        studentModelArrayList.add(new Student("Rajita",1244,"fddf"));
//        studentModelArrayList.add(new Student("Yugal",1244,"fddf"));
//        studentModelArrayList.add(new Student("Rohit",1244,"fddf"));
//        studentModelArrayList.add(new Student("Anjali",1244,"fddf"));



        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new
                RecylerAdapter(studentModelArrayList,
                this);

        recyclerView.setAdapter(recyclerAdapter);




}

    @Override
    public void onListItemClickListener(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(), studentModelArrayList.get(clickedItemIndex).studentName, Toast.LENGTH_SHORT).show();
        String namevalu = studentModelArrayList.get(clickedItemIndex).studentName.toString();

        String addvalue=studentModelArrayList.get(clickedItemIndex).addName.toString();
//        long phvalue=long phone = studentModelArrayList.get(clickedItemIndex).ph.toString();
        Intent intent4=new Intent(activity33.this,Activity4.class);

        intent4.putExtra("NAME", namevalu);
//        intent4.putExtra("PHONE",phvalue);

        intent4.putExtra("ADDRESS",addvalue);
        startActivity(intent4);
    }
}
