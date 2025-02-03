package Human;

public class Human {
    protected String name;
    protected int age;
    protected int numberOfChildren;

    public Human(String name,
                 int age,
                 int numberOfChildren) {
        this.name = name;
        this.age = age;
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfChildren() { return numberOfChildren; }

    @Override
    public String toString() { return "Human { \n\tname=" + name + ", \n\tage=" + age + ", \n\tnumberOfChildren=" + numberOfChildren + "\n}"; }
}
