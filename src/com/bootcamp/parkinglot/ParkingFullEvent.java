package com.bootcamp.parkinglot;

import java.util.List;

/**
 * Created by poulami on 6/29/16.
 */
public class ParkingFullEvent implements NotificationEvent {
    @Override
    public void notifyObservers(List<ParkingLotObserver> observers) {
        observers.forEach(ParkingLotObserver::receiveNotificationOnParkingFull);
    }
}
