package Tax;

public class Main {
    public static void main(String[] args) {
        TaxDatabase taxDB = new TaxDatabase();
        taxDB.addPerson("12345");

        Fine fine1 = new Fine("Speeding", "Kyiv", 100.0);
        Fine fine2 = new Fine("Parking", "Lviv", 50.0);

        taxDB.addFine("12345", fine1);
        taxDB.addFine("12345", fine2);

        taxDB.printDatabase();

        taxDB.printFinesByType("Speeding");
        taxDB.printFinesByCity("Lviv");
    }
}
