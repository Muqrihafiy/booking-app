package com.example.myapplication.recyclerview;



import java.io.Serializable;

//Booking recyclerview
public class Booking implements Serializable {


    String name;
    int serviceID;
    String notes;
    String phone;
    String email;
    int bookingCheck;


    int bookingid;




    public Booking(int bookingid, String name, String notes, String phone, String email) {
        this.name = name;
        this.serviceID = serviceID;
        this.notes = notes;
        this.phone = phone;
        this.email = email;


        this.bookingid = bookingid;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBookingCheck() {
        return bookingCheck;
    }

    public void setBookingCheck(int bookingCheck) {
        this.bookingCheck = bookingCheck;
    }



    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }


}
