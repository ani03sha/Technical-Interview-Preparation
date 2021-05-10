package org.redquark.techinterview.ctci.obejctorienteddesign.parkinglot;

public class Level {

    private final ParkingSpot[] parkingSpots;
    private int availableSpots = 0;

    public Level(int rows, int spotsPerRow) {
        int numberOfSpots = 0;
        parkingSpots = new ParkingSpot[rows * spotsPerRow];
        // Initialize the spots array
        for (int row = 0; row < rows; row++) {
            for (int spot = 0; spot < spotsPerRow / 4; spot++) {
                VehicleSize size = VehicleSize.SMALL;
                parkingSpots[numberOfSpots] = new ParkingSpot(this, row, size);
                numberOfSpots++;
            }
            for (int spot = spotsPerRow / 4; spot < 3 * spotsPerRow / 4; spot++) {
                VehicleSize size = VehicleSize.MEDIUM;
                parkingSpots[numberOfSpots] = new ParkingSpot(this, row, size);
                numberOfSpots++;
            }
            for (int i = 3 * spotsPerRow / 4; i < spotsPerRow; i++) {
                VehicleSize size = VehicleSize.LARGE;
                parkingSpots[numberOfSpots] = new ParkingSpot(this, row, size);
                numberOfSpots++;
            }
            this.availableSpots = numberOfSpots;
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots < vehicle.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.clearSpots();
        boolean success = true;
        for (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++) {
            success &= parkingSpots[i].park(vehicle);
        }
        availableSpots -= vehicle.spotsNeeded;
        return success;
    }

    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for (int i = 0; i < parkingSpots.length; i++) {
            ParkingSpot spot = parkingSpots[i];
            if (lastRow != spot.getRow()) {
                spotsFound = 0;
                lastRow = spot.getRow();
            }
            if (spot.canFitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }

    public void spotFreed() {
        availableSpots++;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public void print() {
        int lastRow = -1;
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getRow() != lastRow) {
                System.out.print(" ");
                lastRow = spot.getRow();
            }
            spot.print();
        }
    }
}
