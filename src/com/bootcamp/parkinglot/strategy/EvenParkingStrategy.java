package com.bootcamp.parkinglot.strategy;

import com.bootcamp.parkinglot.Car;
import com.bootcamp.parkinglot.ParkingLot;
import com.bootcamp.parkinglot.ParkingTicket;
import com.bootcamp.parkinglot.exception.NoSlotAvailableException;

import java.util.List;

/**
 * Created by poulami on 6/29/16.
 */
public class EvenParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingTicket parkTheCar(List<ParkingLot> parkingLots, Car car) throws NoSlotAvailableException {
        int parkingLotNoWithLeastOccupiedSlots = getLeastOccupiedParkingLot(parkingLots, 10);
        if (parkingLotNoWithLeastOccupiedSlots == -1)
            throw new NoSlotAvailableException("No Slot is Available");
        return parkingLots.get(parkingLotNoWithLeastOccupiedSlots).allotTicketToParkingLot();

    }

    private int getLeastOccupiedParkingLot(List<ParkingLot> parkingLots, int capacity) {
        int minNumberOfOccupiedSlots = capacity;
        int parkingLotNoWithLeastOccupiedSlots = -1;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getNoOfAvailableSlots() < minNumberOfOccupiedSlots) {
                parkingLotNoWithLeastOccupiedSlots = parkingLots.indexOf(parkingLot);
            }
        }
        return parkingLotNoWithLeastOccupiedSlots;
    }
}
