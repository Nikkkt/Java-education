package Zoo;

public abstract class Animal {
    protected String name;
    protected double dailyFood;
    protected boolean isPredator;

    public Animal(String name, double dailyFood, boolean isPredator) {
        this.name = name;
        this.dailyFood = dailyFood;
        this.isPredator = isPredator;
    }

    public String getName() { return name; }
    public double getDailyFood() { return dailyFood; }
    public boolean isPredator() { return isPredator; }

    public abstract String getSound();

    @Override
    public String toString() { return getClass().getSimpleName() + " { \n\tname=" + name + "\n}"; }
}
