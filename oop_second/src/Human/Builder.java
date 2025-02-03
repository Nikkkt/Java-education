package Human;

public class Builder extends Human {
    private String specialization;

    public Builder(String name,
                   int age,
                   int numberOfChildren,
                   String specialization) {
        super(name, age, numberOfChildren);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }

    @Override
    public String toString() { return "Builder { \n\tname=" + name + ", \n\tage=" + age + ", \n\tchildren=" + numberOfChildren + ", \n\tspecialization=" + specialization + "\n}"; }
}
