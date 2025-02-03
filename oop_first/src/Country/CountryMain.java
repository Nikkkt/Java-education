package Country;

import java.util.ArrayList;

public class CountryMain {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Харків");
        cities.add("Одеса");

        Country country = new Country();
        country.inputData("Україна", "Європа", 30000000, 380, "Київ", cities);

        System.out.println("Інформація про країну:");
        country.displayData();
    }
}

