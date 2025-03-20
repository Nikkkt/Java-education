package Classes;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    String name;
    int experience;
    double earnings;
    int cargoCount;

    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
        this.earnings = 0;
        this.cargoCount = 0;
    }

    public void addEarnings(double amount) {
        this.earnings += amount;
        this.cargoCount++;
    }
}
