package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.recyclerview.Booking;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {
    public static final  String DBNAME="database.db";
    private static final String TABLE_NAME = "booking";

    public DBhelper(@Nullable Context context) {
        super(context,"database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

         db.execSQL("create table users(username TEXT primary key, password TEXT )");
         db.execSQL("create table "+TABLE_NAME+"(serviceID INTEGER , name TEXT,notes TEXT,email TEXT,phone TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password", password);

        long result  = db.insert("users",null,values);
        if(result==-1)return false;
        else
            return true;




    }

    public void addNewBooking( int serviceID, String name,String notes, String phone, String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

        values.put("serviceID", serviceID);
        values.put("name", name);
        values.put("notes", notes);
        values.put("phone", phone);
        values.put("email", email);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.

    }


    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }else
            return false;






    }

    public Boolean checkuserpass(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username =? and password =?", new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }else
            return false;






    }

    public ArrayList<Booking> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<Booking> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new Booking(cursorCourses.getInt(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

}
