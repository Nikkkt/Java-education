package Classes;

public class Trip {
    Driver driver;
    Truck truck;
    Cargo cargo;
    boolean completed;

    public Trip(Driver driver, Truck truck, Cargo cargo) {
        this.driver = driver;
        this.truck = truck;
        this.cargo = cargo;
        this.completed = false;
    }

    public void completeTrip() {
        this.completed = true;
        driver.addEarnings(cargo.weight * 0.5);
    }
}
