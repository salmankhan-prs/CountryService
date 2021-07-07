package com.example.countryservice.exception;

public class CountryNotFoundException extends Exception {
    public CountryNotFoundException(String message){
        super(message);
    }

}
