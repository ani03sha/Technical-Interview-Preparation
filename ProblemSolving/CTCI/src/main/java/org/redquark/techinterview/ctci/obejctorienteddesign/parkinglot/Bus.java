package org.redquark.techinterview.ctci.obejctorienteddesign.parkinglot;

public class Bus extends Vehicle {

    public Bus() {
        this.spotsNeeded = 5;
        this.size = VehicleSize.LARGE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE;
    }

    @Override
    public void print() {
        System.out.print("Bus ");
    }
}
