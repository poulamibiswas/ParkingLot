package com.bootcamp.parkinglot.strategy;

import com.bootcamp.parkinglot.Car;
import com.bootcamp.parkinglot.ParkingLot;
import com.bootcamp.parkinglot.ParkingTicket;
import com.bootcamp.parkinglot.exception.NoSlotAvailableException;

import java.util.List;

/**
 * Created by poulami on 6/29/16.
 */
public class DefaultParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingTicket parkTheCar(List<ParkingLot> parkingLots, Car car) throws NoSlotAvailableException {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull())
                return parkingLot.allotTicketToParkingLot();
        }
        throw new NoSlotAvailableException("No Slot is Available");
    }
}
