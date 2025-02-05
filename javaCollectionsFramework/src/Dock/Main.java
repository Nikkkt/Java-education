package Dock;

public class Main {
    public static void main(String[] args) {
        DockSimulation dock = new DockSimulation();

        dock.addPassenger("person1");
        dock.addPassenger("person2");
        dock.addPassenger("person3");

        Boat boat = new Boat(false, 2);
        dock.processBoatArrival(boat);

        System.out.println("Passengers left: " + dock.getCurrentPassengers());
    }
}
