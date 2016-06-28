package com.bootcamp.parkinglot;

public class InvalidParkingTicketException extends Throwable {


    private String message;

    public InvalidParkingTicketException(String message) {
        this.message = message;
    }

}
