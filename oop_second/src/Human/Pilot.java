package Human;

public class Pilot extends Human {
    private String licenseType;

    public Pilot(String name,
                 int age,
                 int numberOfChildren,
                 String licenseType) {
        super(name, age, numberOfChildren);
        this.licenseType = licenseType;
    }

    public String getLicenseType() { return licenseType; }

    @Override
    public String toString() { return "Pilot { \n\tname=" + name + ", \n\tage=" + age + ", \n\tchildren=" + numberOfChildren + ", \n\tlicenseType=" + licenseType + "\n}"; }
}
