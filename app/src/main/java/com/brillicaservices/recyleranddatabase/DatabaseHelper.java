package com.brillicaservices.recyleranddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HIMANSHU CHUGH on 12-07-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
        /*
        * Database details*/
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "student_db";

        /*
        * Student_Record table details*/
        private static final String TABLE_NAME = "student_record";
        private static final String STUDENT_NAME = "student_name";
        private static final String STUDENT_ID = "student_id";
        private static final String STUDENT_ADDRESS = "student_address";
        private static final String STUDENT_PHONE_NUMBER = "student_phone";

        /*
        * Table structure*/
        private static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + " ( " + STUDENT_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " TEXT, " + STUDENT_ADDRESS + " TEXT, " +
                STUDENT_PHONE_NUMBER + " INTEGER ); ";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

            onCreate(db);
        }


        public long addNewStudent(Student studentModel) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();

            contentValues.put(STUDENT_NAME, studentModel.studentName);
            contentValues.put(STUDENT_ADDRESS, studentModel.addName);
            contentValues.put(STUDENT_PHONE_NUMBER, studentModel.ph);

            long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

            sqLiteDatabase.close();

            return id;
        }

        public Student getSingleStudentDetails(long id) {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

            Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{STUDENT_ID, STUDENT_NAME, STUDENT_ADDRESS,
                            STUDENT_PHONE_NUMBER}, STUDENT_ID + "=?", new String[]{String.valueOf(id)}, null, null,
                    null, null);

            if (cursor != null) {
                cursor.moveToFirst();
            }

            Student studentModel = new Student(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)),
                    cursor.getString(cursor.getColumnIndex(STUDENT_NAME)),  cursor.getLong(cursor.getColumnIndex(STUDENT_PHONE_NUMBER)),
                    cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS)) );

            cursor.close();

            return studentModel;
        }

        public List<Student> allStudentsDetails() {
            List<Student> studentsList = new ArrayList<>();

            String selectQuery = " SELECT * FROM " + TABLE_NAME;

            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    Student studentModel = new Student();
                    studentModel.setId(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)));
                    studentModel.setName(cursor.getString(cursor.getColumnIndex(STUDENT_NAME)));
                    studentModel.setAddress(cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS)));
                    studentModel.setPhoneNumber(cursor.getLong(cursor.getColumnIndex(STUDENT_PHONE_NUMBER)));

                    studentsList.add(studentModel);
                } while (cursor.moveToNext());
            }

            sqLiteDatabase.close();

            return studentsList;
        }

        public int getStudentsCount() {

            String query = "SELECT * FROM " + TABLE_NAME;

            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

            int totalStudentsCount = cursor.getCount();
            cursor.close();

            return totalStudentsCount;
        }

        public int updateIndividualStudentDetails(Student studentModel) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(STUDENT_NAME, studentModel.getName());
            values.put(STUDENT_ADDRESS, studentModel.getAddress());
            values.put(STUDENT_PHONE_NUMBER, studentModel.getPhoneNumber());

            // updating row
            return sqLiteDatabase.update(TABLE_NAME, values, STUDENT_ID + " = ?",
                    new String[]{String.valueOf(studentModel.getId())});
        }
        }


