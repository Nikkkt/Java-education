package Music;

public class Cello extends MusicalInstrument {
    public Cello(String name, String characteristics) { super(name, characteristics); }

    @Override
    public void Sound() { System.out.println(name + " відтворює насичений тон"); }

    @Override
    public void Show() { System.out.println("Інструмент: " + name); }

    @Override
    public void Desc() { System.out.println("Опис: " + characteristics); }

    @Override
    public void History() { System.out.println(name + " є незамінною частиною класичного оркестру"); }
}
