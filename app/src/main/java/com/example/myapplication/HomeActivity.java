package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.booking.BookingActivity;


public class HomeActivity extends AppCompatActivity {

    SharedPreferences prf;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView result = (TextView)findViewById(R.id.textuser);
        Button btnLogOut = (Button)findViewById(R.id.logoutuser);
        CardView cardView = (CardView) findViewById(R.id.bookingbutton);
        prf = getSharedPreferences("user_details",MODE_PRIVATE);
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        result.setText("Hello, "+prf.getString("username",null));



        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                    i = new Intent(HomeActivity.this, BookingActivity.class);
                    startActivity(i);

            }
        });

    }



}
