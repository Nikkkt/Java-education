package Classes;

public class Request {
    public String destination;
    double weight;
    String cargoType;

    public Request(String destination, double weight, String cargoType) {
        this.destination = destination;
        this.weight = weight;
        this.cargoType = cargoType;
    }
}
