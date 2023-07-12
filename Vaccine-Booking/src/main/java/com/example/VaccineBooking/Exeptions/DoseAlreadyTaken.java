package com.example.VaccineBooking.Exeptions;

public class DoseAlreadyTaken extends RuntimeException {
    public DoseAlreadyTaken(String message) {
        super(message);
    }
}