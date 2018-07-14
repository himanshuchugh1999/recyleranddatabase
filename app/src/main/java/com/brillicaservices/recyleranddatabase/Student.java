package com.brillicaservices.recyleranddatabase;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by HIMANSHU CHUGH on 12-07-2018.
 */

public class Student extends AppCompatActivity {
        String studentName;
        String addName;
        long ph;
        int id;

        public Student(int id, String studentName,long ph, String addName) {
            this.id = id;
            this.studentName = studentName;
            this.addName = addName;
            this.ph = ph;

        }

        public Student(String studentName, long ph, String addName) {
//            this.id = id;
            this.studentName = studentName;
            this.addName = addName;
            this.ph = ph;
        }

        public Student() {

        }

        public long getPhoneNumber() {
            return ph;
        }

        public String getAddress() {
            return addName;
        }


        public String getName() {
            return studentName;
        }

        public int getId() {
            return id;
        }


        public void setAddress(String address) {
            this.addName = address;
        }


        public void setName(String name) {
            this.studentName = name;
        }

        public void setPhoneNumber(long phoneNumber) {
            this.ph = phoneNumber;
        }

        public void setId(int id) {
            this.id = id;
        }
        }







