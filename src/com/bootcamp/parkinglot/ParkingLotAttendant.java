package com.bootcamp.parkinglot;

import com.bootcamp.parkinglot.exception.InvalidParkingTicketException;
import com.bootcamp.parkinglot.exception.NoSlotAvailableException;
import com.bootcamp.parkinglot.strategy.DefaultParkingStrategy;
import com.bootcamp.parkinglot.strategy.EvenParkingStrategy;
import com.bootcamp.parkinglot.strategy.ParkingStrategy;

import java.util.*;

/**
 * Created by poulami on 6/29/16.
 */
public class ParkingLotAttendant {
    List<ParkingLot> parkingLots;

    Map<ParkingTicket, ParkingLot> parkingTicketParkingLotMap;

    ParkingStrategy parkingStrategy;

    public ParkingLotAttendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingLotAttendant(int numberOfParkingLot) {
        parkingLots = new ArrayList<>();
        for (int index = 0; index < numberOfParkingLot; index++)
            parkingLots.add(new ParkingLot(1));
        parkingTicketParkingLotMap = new HashMap<>();
    }

    public ParkingTicket park(Car carToBeParked, ParkingStrategy... parkingStrategies) throws NoSlotAvailableException {
        parkingStrategy = (parkingStrategies.length == 0) ? new DefaultParkingStrategy() : parkingStrategies[0];
        return parkingStrategy.parkTheCar(parkingLots, carToBeParked);
    }

    public boolean unpark(ParkingTicket parkingTicket) throws InvalidParkingTicketException {
        if (!parkingTicketParkingLotMap.containsKey(parkingTicket))
            throw new InvalidParkingTicketException("Invalid Parking Ticket");
        parkingTicketParkingLotMap.get(parkingTicket).unpark(parkingTicket);
        return true;
    }
}
