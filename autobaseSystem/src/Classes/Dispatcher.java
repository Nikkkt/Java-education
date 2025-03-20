package Classes;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    public List<Driver> drivers = new ArrayList<>();
    public List<Truck> trucks = new ArrayList<>();
    public List<Cargo> cargoRequests = new ArrayList<>();
    List<Trip> trips = new ArrayList<>();
    List<RepairRequest> repairRequests = new ArrayList<>();
    Statistics statistics = new Statistics();

    public void assignTrips() {
        for (Cargo cargo : cargoRequests) {
            Driver assignedDriver = null;
            Truck assignedTruck = null;

            for (Driver driver : drivers) if (assignedDriver == null || driver.experience > assignedDriver.experience) assignedDriver = driver;

            for (Truck truck : trucks) if (!truck.isBroken && (assignedTruck == null || truck.capacity >= cargo.weight)) assignedTruck = truck;

            if (assignedDriver != null && assignedTruck != null) {
                Trip trip = new Trip(assignedDriver, assignedTruck, cargo);
                trips.add(trip);
                Logging.log("Driver: " + trip.driver.name + ", Truck: " + trip.truck.model + ", Destination: " + trip.cargo.destination);
                statistics.updateStatistics(trip);
                trip.completeTrip();
            }
        }
        cargoRequests.clear();
    }

    public void printStatistics() { statistics.printStatistics(); }
}
