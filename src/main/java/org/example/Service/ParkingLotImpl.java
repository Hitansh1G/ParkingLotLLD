package org.example.Service;

import org.example.Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotImpl implements ParkingLot{
    public List<ParkingLotFloor>floors;

    public ParkingLotImpl() {
        this.floors = new ArrayList<>();
    }

    @Override
    public void addFloor(ParkingLotFloor floor) {
        floors.add(floor);
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        // Find the first available slot for the given vehicle
        Optional<ParkingSlots> optionalSlot = findAvailableSlot(vehicle.getType());

        if (optionalSlot.isPresent()) {
            ParkingSlots slot = optionalSlot.get();
            slot.setParkedVehicle(vehicle);
            slot.setOccupied(true);
            String ticketId = "PR1234_" + slot.getFloorNumber() + "_" + slot.getSlotNumber();
            return new Ticket(ticketId, vehicle.getRegisterationNumber());
        } else {
            System.out.println("No available slots for vehicle type: " + vehicle.getType());
            return null;
        }
    }


    private Optional<ParkingSlots> findAvailableSlot(VehicalType type) {
        for (ParkingLotFloor floor : floors) {
            Optional<ParkingSlots> optionalSlot = floor.getAvailableSlot(type);
            if (optionalSlot.isPresent()) {
                return optionalSlot;
            }
        }
        return Optional.empty();
    }

    @Override
    public void unparkVehicle(String ticketId) {
        // Extract floor number and slot number from ticketId
        String[] parts = ticketId.split("_");
        int floorNumber = Integer.parseInt(parts[1]);
        int slotNumber = Integer.parseInt(parts[2]);

        // Find the floor
        Optional<ParkingLotFloor> optionalFloor = floors.stream()
                .filter(floor -> floor.getFloorNumber() == floorNumber)
                .findFirst();

        if (optionalFloor.isPresent()) {
            ParkingLotFloor floor = optionalFloor.get();
            // Unpark the vehicle from the slot
            floor.unparkVehicle(slotNumber);
        } else {
            System.out.println("Invalid ticket: " + ticketId);
        }
    }

    @Override
    public void displayFreeSlots(VehicalType type) {
        // Display free slots for the given vehicle type
        for (ParkingLotFloor floor : floors) {
            System.out.println("Floor " + floor.getFloorNumber() + ": " + floor.getFreeSlotsCount(type) + " free slots");
        }
    }

    public void displayOccupiedSlots(VehicalType type) {
        // Display occupied slots for the given vehicle type
        for (ParkingLotFloor floor : floors) {
            System.out.println("Floor " + floor.getFloorNumber() + ": " + floor.getOccupiedSlotsCount(type) + " occupied slots");
        }
    }
    @Override
    public void displayFreeSlotsPerFloor(VehicalType type) {
        // Display number of free slots per floor for the given vehicle type
        for (ParkingLotFloor floor : floors) {
            int freeSlotsCount = floor.getFreeSlotsCount(type);
            if (freeSlotsCount > 0) {
                System.out.println("Floor " + floor.getFloorNumber() + ": " + freeSlotsCount + " free slots");
            }
        }
    }
}
