package com.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private final int totalSlots;
    private List<ParkingTicket> allottedParkingTickets;
    private List<ParkingLotObserver> observers;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.allottedParkingTickets = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void attach(ParkingLotObserver parkingLotObserver) {
        this.observers.add(parkingLotObserver);
    }

    private void notifyAllObservers() {
        this.observers.forEach(ParkingLotObserver::publish);
    }

    public ParkingTicket park() throws NoSlotAvailableException {

        if (isSlotAvailable()) {
            ParkingTicket parkingticket = new ParkingTicket(UUID.randomUUID().toString());
            allottedParkingTickets.add(parkingticket);
            notifyIfAllSlotsTaken();
            return parkingticket;
        }
        throw new NoSlotAvailableException("No slot is available");
    }

    private void notifyIfAllSlotsTaken() {
        if (!this.isSlotAvailable())
            this.notifyAllObservers();
    }

    private boolean isSlotAvailable() {
        return allottedParkingTickets.size() != totalSlots;
    }


    public boolean unpark(ParkingTicket parkingTicket) throws InvalidParkingTicketException {

        if (!allottedParkingTickets.contains(parkingTicket))
            throw new InvalidParkingTicketException("Invalid parking ticket during unpark");

        boolean isUnparked = allottedParkingTickets.remove(parkingTicket);
        notifyIfAllSlotsTaken();
        return isUnparked;
    }

    public boolean isFull() {
        return !this.isSlotAvailable();
    }
}
