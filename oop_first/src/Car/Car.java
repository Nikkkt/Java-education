package Car;

import java.util.Scanner;

public class Car {
    private String carName;
    private String manufacturer;
    private int year;
    private double engineVolume;

    public Car() {
        this.carName = "";
        this.manufacturer = "";
        this.year = 0;
        this.engineVolume = 0.0;
    }

    public Car(String carName,
               String manufacturer,
               int year,
               double engineVolume) {
        this.carName = carName;
        this.manufacturer = manufacturer;
        this.year = year;
        this.engineVolume = engineVolume;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть назву автомобіля: ");

        this.carName = sc.nextLine();
        System.out.print("Введіть назву виробника: ");

        this.manufacturer = sc.nextLine();
        System.out.print("Введіть рік випуску: ");
        this.year = sc.nextInt();

        System.out.print("Введіть об’єм двигуна: ");
        this.engineVolume = sc.nextDouble();
    }

    public void displayData() {
        System.out.println("Назва автомобіля: " + carName);
        System.out.println("Назва виробника: " + manufacturer);
        System.out.println("Рік випуску: " + year);
        System.out.println("Об’єм двигуна: " + engineVolume);
    }

    public String getCarName() { return carName; }
    public void setCarName(String carName) { this.carName = carName; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getEngineVolume() { return engineVolume; }
    public void setEngineVolume(double engineVolume) { this.engineVolume = engineVolume; }
}
