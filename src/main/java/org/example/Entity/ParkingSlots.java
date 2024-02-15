package org.example.Entity;

public class ParkingSlots {
    private int slotNumber;
    private VehicalType type;
    private boolean isOccupied;
    private  Vehicle parkedVehicle;
    private int floorNumber;

    public ParkingSlots(int slotNumber, VehicalType type, boolean isOccupied, Vehicle parkedVehicle, int floorNumber) {
        this.slotNumber = slotNumber;
        this.type = type;
        this.isOccupied = isOccupied;
        this.parkedVehicle = parkedVehicle;
        this.floorNumber = floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicalType getType() {
        return type;
    }

    public void setType(VehicalType type) {
        this.type = type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
