package com.example.VaccineBooking.Exeptions;

public class DoctorNotFound extends RuntimeException{
    public DoctorNotFound(String str) {
        super(str);
    }
}
