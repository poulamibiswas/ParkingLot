package com.bootcamp.parkinglot;

/**
 * Created by poulami on 6/28/16.
 */
public class SecurityPerson extends ParkingLotObserver {

    public SecurityPerson(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.parkingLot.attach(this);
    }

    @Override
    public void publish() {

    }
}
