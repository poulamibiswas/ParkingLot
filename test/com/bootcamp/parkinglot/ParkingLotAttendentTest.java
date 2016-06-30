package com.bootcamp.parkinglot;

import com.bootcamp.parkinglot.exception.NoSlotAvailableException;
import com.bootcamp.parkinglot.strategy.EvenParkingStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by poulami on 6/29/16.
 */
public class ParkingLotAttendentTest {

    Car car;

    @Before
    public void setUp() {
        car = new Car("123");
    }

    @Test
    public void shouldBeAbleToParkTheCar() throws NoSlotAvailableException {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(1);
        Car car = new Car("123");
        ParkingTicket parkingTicket = parkingLotAttendant.park(car);
        assertNotNull(parkingTicket);
    }

    @Test
    public void shouldBeAbleToParkTheCarIfDefaultParkingStrategy() throws NoSlotAvailableException {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(3);
        assertNotNull(parkingLotAttendant.park(car));
    }

    @Test
    public void shouldBeAbleToParkTheCarIfEvenParkingStrategy() throws NoSlotAvailableException {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(3);
        assertNotNull(parkingLotAttendant.park(car, new EvenParkingStrategy()));
    }

    @Test
    public void shouldNotBeAbleToParkTheCarIfParkingLotsAreFull() {
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(parkingLots);


    }
}
