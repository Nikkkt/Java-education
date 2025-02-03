package House;

public class House {
    private Basement basement;
    private Walls[] walls = new Walls[4];
    private Door door;
    private Window[] windows = new Window[4];
    private Roof roof;

    public void setBasement(Basement basement) {
        this.basement = basement;
        System.out.println("Фундамент побудовано.");
    }
    public Basement getBasement() {
        return basement;
    }

    public void setWall(int index, Walls wall) {
        if (index >= 0 && index < walls.length) {
            walls[index] = wall;
            System.out.println("Стіна " + (index + 1) + " побудована.");
        }
    }
    public Walls[] getWalls() {
        return walls;
    }

    public void setDoor(Door door) {
        this.door = door;
        System.out.println("Двері побудовано.");
    }
    public Door getDoor() {
        return door;
    }

    public void setWindow(int index, Window window) {
        if (index >= 0 && index < windows.length) {
            windows[index] = window;
            System.out.println("Вікно " + (index + 1) + " побудовано.");
        }
    }
    public Window[] getWindows() {
        return windows;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
        System.out.println("Дах побудовано.");
    }
    public Roof getRoof() {
        return roof;
    }

    public void showProgress() {
        System.out.println("\nПрогрес будівництва будинку:");
        System.out.println("Фундамент: " + (basement != null ? "Побудовано" : "Не побудовано"));
        for (int i = 0; i < walls.length; i++) {
            System.out.println("Стіна " + (i + 1) + ": " + (walls[i] != null ? "Побудовано" : "Не побудовано"));
        }
        System.out.println("Двері: " + (door != null ? "Побудовано" : "Не побудовано"));
        for (int i = 0; i < windows.length; i++) {
            System.out.println("Вікно " + (i + 1) + ": " + (windows[i] != null ? "Побудовано" : "Не побудовано"));
        }
        System.out.println("Дах: " + (roof != null ? "Побудовано" : "Не побудовано"));
    }

    public boolean isComplete() {
        if (basement == null) return false;
        for (Walls w : walls) {
            if (w == null) return false;
        }
        if (door == null) return false;
        for (Window w : windows) {
            if (w == null) return false;
        }
        if (roof == null) return false;
        return true;
    }
}
