package House;

public class Walls implements IPart {
    private int wallNumber;

    public Walls(int wallNumber) { this.wallNumber = wallNumber; }

    @Override
    public String getPartName() { return "Стіна " + wallNumber; }
}
