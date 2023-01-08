package com.example.myapplication.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class bookingRecycleView extends RecyclerView.Adapter<bookingRecycleView.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Booking> BookingArrayList;
    private Context context;

    // constructor
    public bookingRecycleView(ArrayList<Booking> BookingArrayList, Context context) {
        this.BookingArrayList = BookingArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rbooking_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data 
        // to our views of recycler view item.
        Booking modal = BookingArrayList.get(position);
        holder.tv_name.setText(BookingArrayList.get(position).getName());
        holder.tv_bookingBategory.setText(BookingArrayList.get(position).getNotes());
        holder.tv_paymentStatus.setText(BookingArrayList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return BookingArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        public TextView tv_name,tv_bookingBategory,tv_paymentStatus;
        public Button button_delete_booking;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            tv_name = itemView.findViewById(R.id.tv_nameCrew);
            tv_bookingBategory = itemView.findViewById(R.id.tv_crewProgress);
            tv_paymentStatus = itemView.findViewById(R.id.tv_crewQuantity);
            button_delete_booking = itemView.findViewById(R.id.button_delete_booking);
        }
    }
}