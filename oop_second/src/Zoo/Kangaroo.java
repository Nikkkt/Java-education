package Zoo;

public class Kangaroo extends Animal {

    public Kangaroo(String name) { super(name, 4.0, false); }

    @Override
    public String getSound() { return "Приг-скок"; }
}
