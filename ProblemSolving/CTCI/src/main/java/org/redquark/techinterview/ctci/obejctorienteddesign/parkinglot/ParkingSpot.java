package org.redquark.techinterview.ctci.obejctorienteddesign.parkinglot;

public class ParkingSpot {

    private final VehicleSize spotSize;
    private final int row;
    private final Level level;
    private Vehicle vehicle;

    public ParkingSpot(Level level, int row, VehicleSize spotSize) {
        this.level = level;
        this.row = row;
        this.spotSize = spotSize;
    }

    /**
     * @return true, if the spot is available for parking
     */
    public boolean isAvailable() {
        return vehicle == null;
    }

    /**
     * @return true, if a vehicle can be fit in the spot
     */
    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        this.vehicle = v;
        vehicle.parkInSpots(this);
        return true;
    }

    /**
     * Remove vehicle from the spot
     */
    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }

    public int getRow() {
        return row;
    }

    public VehicleSize getSize() {
        return spotSize;
    }

    public void print() {
        if (vehicle == null) {
            if (spotSize == VehicleSize.SMALL) {
                System.out.print("SMALL ");
            } else if (spotSize == VehicleSize.MEDIUM) {
                System.out.print("MEDIUM ");
            } else if (spotSize == VehicleSize.LARGE) {
                System.out.print("LARGE ");
            }
        } else {
            vehicle.print();
        }
    }
}
