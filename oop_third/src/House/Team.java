package House;

import java.util.*;

public class Team {
    private List<IWorker> workers;
    private TeamLeader leader;

    public Team(TeamLeader leader) {
        this.leader = leader;
        workers = new ArrayList<>();
    }

    public void addWorker(IWorker worker) { workers.add(worker); }

    public void buildHouse(House house) {
        int steps = 0;
        while (!house.isComplete()) {
            for (IWorker worker : workers) {
                worker.work(house);
                steps++;
                if (steps % 2 == 0) leader.work(house);
                if (house.isComplete()) break;
            }
        }
        System.out.println("\nБудівництво будинку завершено!");
    }
}
