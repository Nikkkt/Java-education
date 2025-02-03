package Car;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car();
        car = new Car("Avensis", "Toyota", 1999, 1.8);

        System.out.println("Інформація про автомобіль:");
        car.displayData();
    }
}
