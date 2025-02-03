package Country;

import java.util.ArrayList;
import java.util.Scanner;

public class Country {
    private String countryName;
    private String continent;
    private long population;
    private int telephoneCode;
    private String capital;
    private ArrayList<String> cities;

    public Country() {
        this.countryName = "";
        this.continent = "";
        this.population = 0;
        this.telephoneCode = 0;
        this.capital = "";
        this.cities = new ArrayList<>();
    }

    public Country(String countryName,
                   String continent,
                   long population,
                   int telephoneCode,
                   String capital,
                   ArrayList<String> cities) {
        this.countryName = countryName;
        this.continent = continent;
        this.population = population;
        this.telephoneCode = telephoneCode;
        this.capital = capital;
        this.cities = cities;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть назву країни: ");
        this.countryName = sc.nextLine();

        System.out.print("Введіть назву континенту: ");
        this.continent = sc.nextLine();

        System.out.print("Введіть кількість жителів: ");
        this.population = sc.nextLong();

        System.out.print("Введіть телефонний код: ");
        this.telephoneCode = sc.nextInt();
        sc.nextLine();

        System.out.print("Введіть назву столиці: ");
        this.capital = sc.nextLine();

        System.out.print("Введіть кількість міст: ");
        int n = sc.nextInt();
        sc.nextLine();

        this.cities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Введіть назву міста " + (i + 1) + ": ");
            cities.add(sc.nextLine());
        }
    }

    public void inputData(String countryName, String continent, long population, int telephoneCode, String capital, ArrayList<String> cities) {
        this.countryName = countryName;
        this.continent = continent;
        this.population = population;
        this.telephoneCode = telephoneCode;
        this.capital = capital;
        this.cities = cities;
    }

    public void displayData() {
        System.out.println("Назва країни: " + countryName);
        System.out.println("Континент: " + continent);
        System.out.println("Кількість жителів: " + population);
        System.out.println("Телефонний код: " + telephoneCode);
        System.out.println("Столиця: " + capital);
        System.out.println("Міста: " + cities);
    }

    public String getCountryName() { return countryName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public long getPopulation() { return population; }
    public void setPopulation(long population) { this.population = population; }

    public int getTelephoneCode() { return telephoneCode; }
    public void setTelephoneCode(int telephoneCode) { this.telephoneCode = telephoneCode; }

    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }

    public ArrayList<String> getCities() { return cities; }
    public void setCities(ArrayList<String> cities) { this.cities = cities; }
}

