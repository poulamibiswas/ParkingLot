package com.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private final int totalSlots;
    List<ParkingTicket> allottedParkingTickets;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.allottedParkingTickets = new ArrayList<>();
    }

    public ParkingTicket park() throws NoSlotAvailableException {

        if (isSlotAvailable()) {
            ParkingTicket parkingticket = new ParkingTicket(UUID.randomUUID().toString());
            allottedParkingTickets.add(parkingticket);
            return parkingticket;
        }
        throw new NoSlotAvailableException("No slot is available");

    }

    private boolean isSlotAvailable() {
        return allottedParkingTickets.size() != totalSlots;
    }

    public boolean unpark(ParkingTicket parkingTicket) throws InvalidParkingTicketException {

        if (!allottedParkingTickets.contains(parkingTicket))
            throw new InvalidParkingTicketException("Invalid parking ticket during unpark");
        return allottedParkingTickets.remove(parkingTicket);
    }
}
