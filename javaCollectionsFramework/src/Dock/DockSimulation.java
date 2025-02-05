package Dock;

import java.util.*;

class DockSimulation {
    Queue<String> passengers = new LinkedList<>();
    Random random = new Random();

    public void addPassenger(String name) { passengers.add(name); }

    public void processBoatArrival(Boat boat) {
        int boarding = Math.min(boat.capacity, passengers.size());
        for (int i = 0; i < boarding; i++) passengers.poll();
    }

    public int getCurrentPassengers() { return passengers.size(); }
}