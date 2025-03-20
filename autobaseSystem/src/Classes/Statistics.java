package Classes;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    Map<String, Integer> destinationStats = new HashMap<>();
    Map<String, Integer> driverCargoCount = new HashMap<>();
    Map<String, Double> driverEarnings = new HashMap<>();

    public void updateStatistics(Trip trip) {
        destinationStats.put(trip.cargo.destination, destinationStats.getOrDefault(trip.cargo.destination, 0) + 1);
        driverCargoCount.put(trip.driver.name, driverCargoCount.getOrDefault(trip.driver.name, 0) + 1);
        driverEarnings.put(trip.driver.name, trip.driver.earnings);
    }

    public void printStatistics() {
        System.out.println("Cargo transported per destination: " + destinationStats);
        System.out.println("Cargo transported per driver: " + driverCargoCount);
        System.out.println("Driver earnings: " + driverEarnings);
    }
}
