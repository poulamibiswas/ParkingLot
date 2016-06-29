package com.bootcamp.parkinglot.event;

import com.bootcamp.parkinglot.ParkingLotObserver;

import java.util.List;

/**
 * Created by poulami on 6/29/16.
 */
public interface NotificationEvent {
    public void notifyObservers(List<ParkingLotObserver> observers);
}
