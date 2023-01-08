package com.example.myapplication.booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DBhelper;
import com.example.myapplication.R;
import com.example.myapplication.recyclerview.Booking;
import com.example.myapplication.recyclerview.bookingRecycleView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {


    DBhelper db;

    LinearLayoutManager linearLayoutManager;


    public FloatingActionButton fbtn_createBooking;
    private bookingRecycleView BookingRecycleView;
    private ArrayList<Booking> BookingArrayList;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        BookingArrayList = new ArrayList<>();
        db =new DBhelper(this);
        BookingArrayList = db.readCourses();


        BookingRecycleView = new bookingRecycleView(BookingArrayList, BookingActivity.this);
        recyclerView = findViewById(R.id. recycler_view);

        linearLayoutManager = new LinearLayoutManager(BookingActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(BookingRecycleView);



        fbtn_createBooking =findViewById(R.id.fbtn_createBooking);

        fbtn_createBooking.setOnClickListener(new View.OnClickListener() {
            String name;
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BookingActivity.this, AddBookingDetail.class);

                startActivity(intent);



            }
        });
    }

}
