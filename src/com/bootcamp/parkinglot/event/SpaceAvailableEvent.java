package com.bootcamp.parkinglot.event;

import com.bootcamp.parkinglot.ParkingLotObserver;

import java.util.List;

/**
 * Created by poulami on 6/29/16.
 */
public class SpaceAvailableEvent implements NotificationEvent {
    @Override
    public void notifyObservers(List<ParkingLotObserver> observers) {
        observers.forEach(ParkingLotObserver::receiveNotificationOnParkingSpaceAvailable);
    }
}
