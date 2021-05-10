package org.redquark.techinterview.ctci.obejctorienteddesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        // Construct the parking lot
        int numberOfLevels = 5;
        int numberOfRows = 10;
        int spotsPerRow = 20;
        ParkingLot parkingLot = new ParkingLot(numberOfLevels, numberOfRows, spotsPerRow);

        System.out.println("\n----------------------< PARKING >----------------------\n");

        // Park some vehicles
        List<Vehicle> motorcycles = new ArrayList<>();
        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> buses = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Vehicle bus = new Bus();
            buses.add(bus);
            if (parkingLot.parkVehicle(bus)) {
                System.out.print("Bus parking successful ");
            }
        }
        for (int i = 1; i <= 250; i++) {
            Vehicle motorCycle = new MotorCycle();
            motorcycles.add(motorCycle);
            if (parkingLot.parkVehicle(motorCycle)) {
                System.out.print("Motorcycle parking successful ");
            }
            Vehicle car = new Car();
            cars.add(car);
            if (parkingLot.parkVehicle(car)) {
                System.out.print("Car parking successful ");
            }
        }

        System.out.println("\n");

        parkingLot.print();
        // Get data for all the levels
        for (int i = 0; i < numberOfLevels; i++) {
            Level level = parkingLot.getLevel(i);
            System.out.println("Available spots for Level - " + i + ": " + level.getAvailableSpots());
        }

        System.out.println("\n----------------------< UNPARKING >----------------------\n");

        // Unpark some vehicles
        for (int i = 1; i <= 100; i++) {
            Vehicle motorCycle = motorcycles.get(i - 1);
            parkingLot.unparkVehicle(motorCycle);
            Vehicle car = cars.get(i - 1);
            parkingLot.unparkVehicle(car);
            Vehicle bus = buses.get(i - 1);
            parkingLot.unparkVehicle(bus);
        }

        parkingLot.print();
        // Get data for all the levels
        for (int i = 0; i < numberOfLevels; i++) {
            Level level = parkingLot.getLevel(i);
            System.out.println("Available spots for Level - " + i + ": " + level.getAvailableSpots());
        }
    }
}
