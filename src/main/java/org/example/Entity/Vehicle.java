package org.example.Entity;

public class Vehicle {
    private String registerationNumber;
    private String colour;
    private VehicalType type;

    public Vehicle(String registerationNumber, String colour, VehicalType type) {
        this.registerationNumber = registerationNumber;
        this.colour = colour;
        this.type = type;
    }

    public String getRegisterationNumber() {
        return registerationNumber;
    }

    public void setRegisterationNumber(String registerationNumber) {
        this.registerationNumber = registerationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public VehicalType getType() {
        return type;
    }

    public void setType(VehicalType type) {
        this.type = type;
    }
}
