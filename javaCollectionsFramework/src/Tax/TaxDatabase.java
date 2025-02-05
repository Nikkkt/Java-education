package Tax;

import java.util.*;

class TaxDatabase {
    private Map<String, List<Fine>> database = new HashMap<>();

    public void addPerson(String id) { database.putIfAbsent(id, new ArrayList<>()); }

    public void addFine(String id, Fine fine) { database.computeIfAbsent(id, k -> new ArrayList<>()).add(fine); }

    public void removeFine(String id, Fine fine) { database.getOrDefault(id, new ArrayList<>()).remove(fine); }

    public void printDatabase() { database.forEach((id, fines) -> { System.out.println("ID: " + id + " Fines: " + fines); }); }

    public void printFinesByType(String type) { database.forEach((id, fines) -> { fines.stream().filter(f -> f.type.equals(type)).forEach(System.out::println); }); }

    public void printFinesByCity(String city) { database.forEach((id, fines) -> { fines.stream().filter(f -> f.city.equals(city)).forEach(System.out::println); }); }
}