package com.hellofresh.api.step_definitions.pojo;

import com.github.javafaker.Faker;

public class Booking {
    Faker faker = new Faker();

    BookingDates bookingdates;
    int bookingid = 0;
    boolean depositpaid = true;
    String email;
    String firstname;
    String lastname;
    String phone;
    int roomid = 0;

    public Booking(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
        this.bookingid = Integer.parseInt(faker.number().digits(4));
        this.email = faker.internet().emailAddress();
        this.firstname = faker.name().firstName();
        this.lastname = faker.name().lastName();
        this.phone = faker.phoneNumber().cellPhone();
        this.roomid = Integer.parseInt(faker.number().digits(3));
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }
}
