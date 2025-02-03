package Zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals;

    public Zoo() { animals = new ArrayList<>(); }

    public void addAnimal(Animal animal) { animals.add(animal); }

    public List<Animal> getAnimals() { return animals; }

    public int countPredators() {
        int count = 0;
        for (Animal a : animals) if (a.isPredator()) count++;
        return count;
    }

    public void printFeedRequirements() {
        double predatorsFood = 0;
        double herbivoresFood = 0;
        for (Animal a : animals) {
            if (a.isPredator()) predatorsFood += a.getDailyFood();
            else herbivoresFood += a.getDailyFood();
        }
        System.out.println("Загальний обсяг корму для хижаків (на день): " + predatorsFood + " кг");
        System.out.println("Загальний обсяг корму для травоїдних (на день): " + herbivoresFood + " кг");
    }
}
