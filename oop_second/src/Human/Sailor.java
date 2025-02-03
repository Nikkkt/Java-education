package Human;

public class Sailor extends Human {
    private int yearsAtSea;

    public Sailor(String name,
                  int age,
                  int numberOfChildren,
                  int yearsAtSea) {
        super(name, age, numberOfChildren);
        this.yearsAtSea = yearsAtSea;
    }

    public int getYearsAtSea() { return yearsAtSea; }

    @Override
    public String toString() { return "Sailor { \n\tname=" + name + ", \n\tage=" + age + ", \n\tchildren=" + numberOfChildren + ", \n\tyearsAtSea=" + yearsAtSea + "\n}"; }
}
