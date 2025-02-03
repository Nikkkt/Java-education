package Music;

public abstract class MusicalInstrument implements IInfo {
    protected String name;
    protected String characteristics;

    public MusicalInstrument(String name, String characteristics) {
        this.name = name;
        this.characteristics = characteristics;
    }
}
