package com.example.VaccineBooking.Exeptions;

public class PersonNotFoundExp extends RuntimeException{
    public PersonNotFoundExp(String message) {
        super(message);
    }
}
