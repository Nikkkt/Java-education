package House;

public class Window implements IPart {
    private int windowNumber;

    public Window(int windowNumber) { this.windowNumber = windowNumber; }

    @Override
    public String getPartName() { return "Вікно " + windowNumber; }
}
