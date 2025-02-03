package Human;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> friends = new ArrayList<>();
        friends.add(new Builder("Вася", 20, 0, "Принеси, подай"));
        friends.add(new Sailor("Петя", 25, 1, 5));
        friends.add(new Pilot("Гена", 30, 2, "Міжнародна"));

        int totalChildren = 0;
        for (Human friend : friends) totalChildren += friend.getNumberOfChildren();
        System.out.println("Сумарна кількість дітей: " + totalChildren);
    }
}
