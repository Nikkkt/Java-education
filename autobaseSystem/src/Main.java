import Classes.*;

public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.drivers.add(new Driver("Ivan", 5));
        dispatcher.drivers.add(new Driver("Petro", 10));
        dispatcher.trucks.add(new Truck("Volvo", 2000));
        dispatcher.trucks.add(new Truck("MAN", 3000));
        dispatcher.cargoRequests.add(new Cargo("Kyiv", 1500, "Furniture"));
        dispatcher.assignTrips();
        dispatcher.printStatistics();
    }
}