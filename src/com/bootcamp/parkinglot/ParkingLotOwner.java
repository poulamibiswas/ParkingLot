package com.bootcamp.parkinglot;

/**
 * Created by poulami on 6/28/16.
 */
public class ParkingLotOwner extends ParkingLotObserver {

    public ParkingLotOwner(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.parkingLot.attach(this);
    }

    @Override
    public void publish() {

    }
}
