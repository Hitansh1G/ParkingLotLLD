package org.example.Service;

import org.example.Entity.ParkingLotFloor;
import org.example.Entity.Ticket;
import org.example.Entity.VehicalType;
import org.example.Entity.Vehicle;

public interface ParkingLot {
    public void addFloor(ParkingLotFloor floor);
    public Ticket parkVehicle(Vehicle vehicle);
    public void unparkVehicle(String ticketId);
    public void displayFreeSlots(VehicalType type);
    public void displayFreeSlotsPerFloor(VehicalType type);
}
