package Zoo;

public class Wolf extends Animal {

    public Wolf(String name) { super(name, 8.0, true); }

    @Override
    public String getSound() { return "Вууу"; }
}
