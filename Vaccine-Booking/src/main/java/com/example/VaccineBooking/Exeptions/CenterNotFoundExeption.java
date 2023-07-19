package com.example.VaccineBooking.Exeptions;

public class CenterNotFoundExeption extends RuntimeException{
    public CenterNotFoundExeption(String str) {
        super(str);
    }
}
