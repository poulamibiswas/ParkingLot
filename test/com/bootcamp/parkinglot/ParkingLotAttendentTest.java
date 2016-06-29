package com.bootcamp.parkinglot;

import com.bootcamp.parkinglot.exception.NoSlotAvailableException;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by poulami on 6/29/16.
 */
public class ParkingLotAttendentTest {

    @Test
    public void shouldBeAbleToParkTheCar() throws NoSlotAvailableException {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant(1);
        Car car = new Car("123");
        ParkingTicket parkingTicket = parkingLotAttendant.park(car);
        assertNotNull(parkingTicket);
    }

    @Test
    public void shouldBeAbleToUnparkTheCar() {

    }
}
