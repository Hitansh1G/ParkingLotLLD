package org.example;

import org.example.Entity.*;
import org.example.Service.*;

public class Main {
    public static void main(String[] args) {
        // Create a parking lot
        ParkingLotImpl parkingLot = new ParkingLotImpl();

        // Add floors to the parking lot
        ParkingLotFloor floor1 = new ParkingLotFloor(1);
        ParkingLotFloor floor2 = new ParkingLotFloor(2);

        // Add parking slots to each floor
        for (int i = 1; i <= 10; i++) {
            floor1.addParkingSlot(new ParkingSlots(i, VehicalType.TRUCK, false, null, 1));
        }
        for (int i = 1; i <= 20; i++) {
            floor1.addParkingSlot(new ParkingSlots(i, VehicalType.BIKE, false, null, 1));
            floor1.addParkingSlot(new ParkingSlots(i, VehicalType.BIKE, false, null, 1));
        }
        for (int i = 1; i <= 50; i++) {
            floor1.addParkingSlot(new ParkingSlots(i, VehicalType.CAR, false, null, 1));
        }

        for (int i = 1; i <= 30; i++) {
            floor2.addParkingSlot(new ParkingSlots(i, VehicalType.BIKE, false, null, 2));
            floor2.addParkingSlot(new ParkingSlots(i, VehicalType.BIKE, false, null, 2));
        }
        for (int i = 1; i <= 70; i++) {
            floor2.addParkingSlot(new ParkingSlots(i, VehicalType.CAR, false, null, 2));
        }

        // Add the floors to the parking lot
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        // Park vehicles
        Vehicle car1 = new Vehicle("ABC123", "Red", VehicalType.CAR);
        Ticket ticket1 = parkingLot.parkVehicle(car1);
        System.out.println("Parked car with registration number " + car1.getRegisterationNumber() + ". Ticket ID: " + ticket1.getTicketId());

        Vehicle bike1 = new Vehicle("XYZ789", "Blue", VehicalType.BIKE);
        Ticket ticket2 = parkingLot.parkVehicle(bike1);
        System.out.println("Parked bike with registration number " + bike1.getRegisterationNumber() + ". Ticket ID: " + ticket2.getTicketId());

        // Display free slots
        parkingLot.displayFreeSlots(VehicalType.CAR);
        parkingLot.displayFreeSlots(VehicalType.BIKE);
        parkingLot.displayFreeSlots(VehicalType.TRUCK);

        // Unpark a vehicle
        parkingLot.unparkVehicle(ticket1.getTicketId());
        System.out.println("Vehicle with ticket ID " + ticket1.getTicketId() + " has been unparked.");

        // Display occupied slots
        parkingLot.displayOccupiedSlots(VehicalType.CAR);
    }
}
