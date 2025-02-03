package Zoo;

public class Rabbit extends Animal {

    public Rabbit(String name) { super(name, 0.5, false); }

    @Override
    public String getSound() { return "Піп"; }
}
