package Task4;

public class Projector {
    private String name;
    private int year;
    private double price;
    private String manufacturer;

    public Projector(String name, int year, double price, String manufacturer) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() { return name; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getManufacturer() { return manufacturer; }

    @Override
    public String toString() {
        return "Projector {" +
                "\n\tname='" + name + '\'' +
                ", \n\tyear=" + year +
                ", \n\tprice=" + price +
                ", \n\tmanufacturer='" + manufacturer + '\'' +
                "\n}";
    }
}
