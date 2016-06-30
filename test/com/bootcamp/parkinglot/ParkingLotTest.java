package com.bootcamp.parkinglot;

import com.bootcamp.parkinglot.exception.InvalidParkingTicketException;
import com.bootcamp.parkinglot.exception.NoSlotAvailableException;
import com.bootcamp.parkinglot.strategy.DefaultParkingStrategy;
import com.bootcamp.parkinglot.strategy.ParkingStrategy;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ParkingLotTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

//    @Test
//    public void shouldBeAbleToParkCar() throws NoSlotAvailableException {
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car carToBeParked = new Car("1234");
//        parkingLot.park(carToBeParked);
//    }
//
//
//    @Test
//    public void shouldBeAbleToUnparkCarIfParked() throws InvalidParkingTicketException, NoSlotAvailableException {
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car carToBeParked = new Car("1234");
//        ParkingTicket parkingTicket = parkingLot.park(carToBeParked);
//        assertTrue(parkingLot.unpark(parkingTicket));
//    }


    @Test(expected = InvalidParkingTicketException.class)
    public void shouldNotBeAbleToUnparkCarIfParkingTicketIsInvalid() throws InvalidParkingTicketException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingTicket invalidParkingTicket = new ParkingTicket("Invalid Parking Ticket");
        parkingLot.unpark(invalidParkingTicket);
    }

//    @Test(expected = InvalidParkingTicketException.class)
//    public void shouldNotBeAbleToUnparkCarIfAlreadyUnparked() throws InvalidParkingTicketException, NoSlotAvailableException {
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car carToBeParked = new Car("1234");
//        ParkingTicket parkingTicket = parkingLot.park(carToBeParked);
//        assertTrue(parkingLot.unpark(parkingTicket));
//        parkingLot.unpark(parkingTicket);
//    }
//
//    @Test
//    public void shouldKnowWhenTheParkingIsFull() throws InvalidParkingTicketException, NoSlotAvailableException {
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car carToBeParked = new Car("1234");
//        ParkingTicket parkingTicket = parkingLot.park(carToBeParked);
//        assertTrue(parkingLot.isFull());
//        parkingLot.unpark(parkingTicket);
//        assertFalse(parkingLot.isFull());
//    }

//    @Test
//    public void shouldNotifyAllConsumersWhenLotIsFull() throws InvalidParkingTicketException, NoSlotAvailableException {
//        ParkingLot parkingLot = new ParkingLot(1);
//        ParkingLotObserver parkingLotOwner = Mockito.mock(ParkingLotOwner.class);
//        ParkingLotObserver securityPerson = Mockito.mock(SecurityPerson.class);
//        parkingLot.attach(parkingLotOwner);
//        parkingLot.attach(securityPerson);
//        Car carToBeParked = new Car("1234");
//        parkingLot.park(carToBeParked);
//        verify(parkingLotOwner, times(1)).receiveNotificationOnParkingFull();
//        verify(securityPerson, times(1)).receiveNotificationOnParkingFull();
//    }
//
//    @Test
//    public void shouldNotifyAllConsumersWhenSpaceIsAvailable() throws NoSlotAvailableException, InvalidParkingTicketException {
//        ParkingLot parkingLot = new ParkingLot(1);
//        ParkingLotObserver parkingLotOwner = Mockito.mock(ParkingLotOwner.class);
//        parkingLot.attach(parkingLotOwner);
//        Car carToBeParked = new Car("1234");
//        ParkingTicket parkingTicket = parkingLot.park(carToBeParked);
//
//        parkingLot.unpark(parkingTicket);
//        verify(parkingLotOwner, times(1)).receiveNotificationOnParkingSpaceAvailable();
//    }
//
//    @Test
//    public void shouldBeAbleParkCarByAttendant() {
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car carToBeParked = new Car("1234");
//        ParkingLotAttendant attendant = new ParkingLotAttendant(1);
//    }

//    @Test
//    public void shouldUseDefaultParkingStrategyIfNoStrategyTypeIsGiven() throws NoSlotAvailableException {
//        ParkingLot parkingLot = new ParkingLot(1);
//        ParkingStrategy parkingStrategy = new DefaultParkingStrategy();
//        Car carToBeParked = new Car("1234");
//        parkingLot.park(carToBeParked);
//        //verify(parkingStrategy, times(1)).parkTheCar(carToBeParked);
//    }

}
