package com.bootcamp.parkinglot;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class ParkingLotTest {

    @Test
    public void shouldBeAbleToParkCarIfSlotIsAvailable() throws NoSlotAvailableException {
        ParkingLot parkingLot = new ParkingLot(100);
        ParkingTicket parkingTicket = parkingLot.park();
        assertNotNull(parkingTicket);
    }

    @Test(expected = NoSlotAvailableException.class)
    public void shouldNotBeAbleToParkCarIfSlotIsUnavailable() throws NoSlotAvailableException {
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingTicket parkingTicket = parkingLot.park();
        assertNull(parkingTicket);
    }

    @Test
    public void shouldBeAbleToUnparkCarIfParked() throws InvalidParkingTicketException, NoSlotAvailableException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingTicket parkingTicket = parkingLot.park();
        assertTrue(parkingLot.unpark(parkingTicket));
    }


    @Test(expected = InvalidParkingTicketException.class)
    public void shouldNotBeAbleToUnparkCarIfParkingTicketIsInvalid() throws InvalidParkingTicketException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingTicket invalidParkingTicket = new ParkingTicket("Invalid Parking Ticket");
        parkingLot.unpark(invalidParkingTicket);
    }

    @Test(expected = InvalidParkingTicketException.class)
    public void shouldNotBeAbleToUnparkCarIfAlreadyUnparked() throws InvalidParkingTicketException, NoSlotAvailableException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingTicket parkingTicket = parkingLot.park();
        assertTrue(parkingLot.unpark(parkingTicket));
        parkingLot.unpark(parkingTicket);

    }
}
