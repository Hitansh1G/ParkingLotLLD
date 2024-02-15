package org.example.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotFloor {
    private int floorNumber;
    private List<ParkingSlots>slots;

    public ParkingLotFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
    }

    public void addParkingSlot(ParkingSlots slot){
        slots.add(slot);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlots> getSlots() {
        return slots;
    }


    public Optional<ParkingSlots> getAvailableSlot(VehicalType type) {
        for (ParkingSlots slot : slots) {
            if (!slot.isOccupied() && slot.getType() == type) {
                return Optional.of(slot);
            }
        }
        return Optional.empty();
    }

    public void unparkVehicle(int slotNumber) {
        for (ParkingSlots slot : slots) {
            if (slot.getSlotNumber() == slotNumber) {
                slot.setOccupied(false);
                slot.setParkedVehicle(null);
                break;
            }
        }
    }

    public int getFreeSlotsCount(VehicalType type) {
        int count = 0;
        for (ParkingSlots slot : slots) {
            if (!slot.isOccupied() && slot.getType() == type) {
                count++;
            }
        }
        return count;
    }

    public int getOccupiedSlotsCount(VehicalType type) {
        int count = 0;
        for (ParkingSlots slot : slots) {
            if (slot.isOccupied() && slot.getType() == type) {
                count++;
            }
        }
        return count;
    }}
