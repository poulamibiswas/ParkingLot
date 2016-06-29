package com.bootcamp.parkinglot;

import com.bootcamp.parkinglot.exception.InvalidParkingTicketException;
import com.bootcamp.parkinglot.exception.NoSlotAvailableException;

import java.util.*;

/**
 * Created by poulami on 6/29/16.
 */
public class ParkingLotAttendant {
    List<ParkingLot> parkingLots;

    Map<ParkingTicket, ParkingLot> parkingTicketParkingLotMap;

    public ParkingLotAttendant(int numberOfParkingLot) {
        parkingLots = new ArrayList<>();
        for (int index = 0; index < numberOfParkingLot; index++)
            parkingLots.add(new ParkingLot(1));
        parkingTicketParkingLotMap = new HashMap<>();
    }

    public ParkingTicket park(Car carToBeParked) throws NoSlotAvailableException {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                parkingLot.park(carToBeParked);
                ParkingTicket parkingTicket = new ParkingTicket(UUID.randomUUID().toString());
                parkingTicketParkingLotMap.put(parkingTicket, parkingLot);
                return parkingTicket;
            }
        }
        throw new NoSlotAvailableException("No Slot is available");
    }

    public boolean unpark(ParkingTicket parkingTicket) throws InvalidParkingTicketException {
        if (!parkingTicketParkingLotMap.containsKey(parkingTicket))
            throw new InvalidParkingTicketException("Invalid Parking Ticket");
        parkingTicketParkingLotMap.get(parkingTicket).unpark(parkingTicket);
        return true;
    }
}
