package House;

public class Worker implements IWorker {
    private String name;

    public Worker(String name) { this.name = name; }

    @Override
    public void work(House house) {
        if (house.getBasement() == null) {
            house.setBasement(new Basement());
            System.out.println(name + " побудував фундамент.");
            return;
        }

        Walls[] walls = house.getWalls();
        int wallIndex = -1;
        for (int i = 0; i < walls.length; i++) {
            if (walls[i] == null) {
                wallIndex = i;
                break;
            }
        }

        if (wallIndex != -1) {
            house.setWall(wallIndex, new Walls(wallIndex + 1));
            System.out.println(name + " побудував стіну " + (wallIndex + 1) + ".");
            return;
        }

        if (house.getDoor() == null) {
            house.setDoor(new Door());
            System.out.println(name + " побудував двері.");
            return;
        }

        Window[] windows = house.getWindows();
        int windowIndex = -1;
        for (int i = 0; i < windows.length; i++) {
            if (windows[i] == null) {
                windowIndex = i;
                break;
            }
        }

        if (windowIndex != -1) {
            house.setWindow(windowIndex, new Window(windowIndex + 1));
            System.out.println(name + " побудував вікно " + (windowIndex + 1) + ".");
            return;
        }

        if (house.getRoof() == null) {
            house.setRoof(new Roof());
            System.out.println(name + " побудував дах.");
            return;
        }
    }
}
