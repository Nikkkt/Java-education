package Music;

public class Main {
    public static void main(String[] args) {
        MusicalInstrument[] instruments = {
                new Violin("Скрипка", "Струнний інструмент, що грається смичком"),
                new Trombone("Тромбон", "Мідний інструмент з висувною трубою"),
                new Ukulele("Укулеле", "Невеликий струнний інструмент гавайського походження"),
                new Cello("Віолончель", "Великий струнний інструмент з глибоким звуком")
        };

        for (MusicalInstrument instrument : instruments) {
            instrument.Show();
            instrument.Desc();
            instrument.Sound();
            instrument.History();
            System.out.println("--------------------");
        }
    }
}
