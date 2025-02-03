package Music;

public class Trombone extends MusicalInstrument {
    public Trombone(String name, String characteristics) { super(name, characteristics); }

    @Override
    public void Sound() { System.out.println(name + " видає глибокий звук"); }

    @Override
    public void Show() { System.out.println("Інструмент: " + name); }

    @Override
    public void Desc() { System.out.println("Опис: " + characteristics); }

    @Override
    public void History() { System.out.println(name + " використовується в джазі та симфонічних оркестрах"); }
}
