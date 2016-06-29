package com.bootcamp.parkinglot;

import java.util.List;

/**
 * Created by poulami on 6/29/16.
 */
public interface NotificationEvent {
    public void notifyObservers(List<ParkingLotObserver> observers);
}
