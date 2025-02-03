package House;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        TeamLeader leader = new TeamLeader("Іван");
        Team team = new Team(leader);

        team.addWorker(new Worker("Робітник А"));
        team.addWorker(new Worker("Робітник Б"));
        team.addWorker(new Worker("Робітник В"));

        team.buildHouse(house);
    }
}
