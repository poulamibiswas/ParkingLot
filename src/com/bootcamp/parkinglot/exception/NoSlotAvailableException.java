package com.bootcamp.parkinglot.exception;

/**
 * Created by poulami on 6/28/16.
 */
public class NoSlotAvailableException extends Throwable {
    String errorMessage;

    public NoSlotAvailableException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
