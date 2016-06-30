package com.bootcamp.parkinglot;

import com.bootcamp.parkinglot.event.NotificationEvent;
import com.bootcamp.parkinglot.event.ParkingFullEvent;
import com.bootcamp.parkinglot.event.SpaceAvailableEvent;
import com.bootcamp.parkinglot.exception.InvalidParkingTicketException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private final int totalSlots;
    private List<ParkingTicket> allottedParkingTickets;
    private List<ParkingLotObserver> observers;
    private NotificationEvent event;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.allottedParkingTickets = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void attach(ParkingLotObserver parkingLotObserver) {
        this.observers.add(parkingLotObserver);
    }

    private void notifyAllObservers() {
        this.observers.forEach(ParkingLotObserver::receiveNotificationOnParkingFull);
    }

//    public ParkingTicket park(Car carToBeParked) throws NoSlotAvailableException {
//        if (isSlotAvailable()) {
//            notifyIfAllSlotsTaken();
//            return allotTicketToParkingLot();
//        }
//        throw new NoSlotAvailableException("No slot is available");
//    }

    private void notifyIfAllSlotsTaken() {
        if (!this.isSlotAvailable()) {
            event = new ParkingFullEvent();
            event.notifyObservers(observers);
        }
    }

    private boolean isSlotAvailable() {
        return allottedParkingTickets.size() != totalSlots;
    }


    public boolean unpark(ParkingTicket parkingTicket) throws InvalidParkingTicketException {

        if (!allottedParkingTickets.contains(parkingTicket))
            throw new InvalidParkingTicketException("Invalid parking ticket during unpark");
        if (isFull()) {
            notifyParkingSpaceAvailable();
        }
        return allottedParkingTickets.remove(parkingTicket);
    }

    private void notifyParkingSpaceAvailable() {
        event = new SpaceAvailableEvent();
        event.notifyObservers(observers);
    }

    public boolean isFull() {
        return !this.isSlotAvailable();
    }

    public int getNoOfAvailableSlots() {
        return (this.totalSlots - this.allottedParkingTickets.size());
    }

    public ParkingTicket allotTicketToParkingLot() {
        ParkingTicket parkingticket = new ParkingTicket(UUID.randomUUID().toString());
        allottedParkingTickets.add(parkingticket);
        return parkingticket;
    }
}
