package Music;

public class Ukulele extends MusicalInstrument {
    public Ukulele(String name, String characteristics) { super(name, characteristics); }

    @Override
    public void Sound() { System.out.println(name + " відтворює легкий звук"); }

    @Override
    public void Show() { System.out.println("Інструмент: " + name); }

    @Override
    public void Desc() { System.out.println("Опис: " + characteristics); }

    @Override
    public void History() { System.out.println(name + " має гавайське походження"); }
}
