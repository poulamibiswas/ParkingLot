package com.bootcamp.parkinglot;

/**
 * Created by poulami on 6/28/16.
 */
public abstract class ParkingLotObserver {

    protected ParkingLot parkingLot;

    public abstract void receiveNotificationOnParkingFull();

    public  abstract void receiveNotificationOnParkingSpaceAvailable();
}
