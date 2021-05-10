package org.redquark.techinterview.ctci.obejctorienteddesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    private final List<ParkingSpot> parkingSpots = new ArrayList<>();
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded() {
        return this.spotsNeeded;
    }

    public VehicleSize getSize() {
        return this.size;
    }

    /**
     * @param spot - spot to be used for parking
     */
    public void parkInSpots(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    /**
     * Remove parking spots needed to park this vehicle
     */
    public void clearSpots() {
        for (ParkingSpot parkingSpot : parkingSpots) {
            parkingSpot.removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);

    public abstract void print();
}
