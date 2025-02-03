package Zoo;

public class Tiger extends Animal {

    public Tiger(String name) { super(name, 10.0, true); }

    @Override
    public String getSound() { return "Рррр"; }
}
