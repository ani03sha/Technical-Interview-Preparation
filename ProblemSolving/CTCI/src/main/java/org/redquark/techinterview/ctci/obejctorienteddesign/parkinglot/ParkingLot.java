package org.redquark.techinterview.ctci.obejctorienteddesign.parkinglot;

public class ParkingLot {

    private final Level[] levels;
    private final int numberOfLevels;

    public ParkingLot(int numberOfLevels, int numberOfRows, int spotsPerRow) {
        this.numberOfLevels = numberOfLevels;
        levels = new Level[this.numberOfLevels];
        for (int i = 0; i < numberOfLevels; i++) {
            levels[i] = new Level(numberOfRows, spotsPerRow);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void unparkVehicle(Vehicle vehicle) {
        vehicle.clearSpots();
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level - " + i + ": ");
            levels[i].print();
            System.out.println();
        }
        System.out.println();
    }

    public Level getLevel(int index) {
        if (index < 0 && index >= numberOfLevels) {
            throw new IndexOutOfBoundsException("No such leve exists");
        }
        return levels[index];
    }
}
