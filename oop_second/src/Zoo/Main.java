package Zoo;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        zoo.addAnimal(new Tiger("Тигр"));
        zoo.addAnimal(new Wolf("Вовк"));
        zoo.addAnimal(new Rabbit("Кролик"));
        zoo.addAnimal(new Kangaroo("Кенгуру"));
        zoo.addAnimal(new Tiger("Тигр 2"));

        System.out.println("Кількість хижаків у зоопарку: " + zoo.countPredators());

        zoo.printFeedRequirements();

        System.out.println("\nЗвуки тварин:");
        for (Animal a : zoo.getAnimals()) System.out.println(a.getName() + " (" + a.getClass().getSimpleName() + "): " + a.getSound());
    }
}
