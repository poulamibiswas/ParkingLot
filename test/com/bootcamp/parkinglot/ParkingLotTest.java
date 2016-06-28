package com.bootcamp.parkinglot;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Test
    public void shouldKnowWhenTheParkingIsFull() throws InvalidParkingTicketException, NoSlotAvailableException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingTicket parkingTicket = parkingLot.park();
        assertTrue(parkingLot.isFull());
        parkingLot.unpark(parkingTicket);
        assertFalse(parkingLot.isFull());
    }

    @Test
    public void shouldNotifyAllConsumersWhenLotIsFull() throws InvalidParkingTicketException, NoSlotAvailableException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotObserver parkingLotOwner = Mockito.mock(ParkingLotOwner.class);
        ParkingLotObserver securityPerson = Mockito.mock(SecurityPerson.class);
        parkingLot.attach(parkingLotOwner);
        parkingLot.attach(securityPerson);
        parkingLot.park();
        verify(parkingLotOwner, times(1)).publish();
        verify(securityPerson, times(1)).publish();
    }
}
