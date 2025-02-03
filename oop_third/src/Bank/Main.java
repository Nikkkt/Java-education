package Bank;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Map<Integer, Integer> initialLoad = new HashMap<>();
        for (int denom : new int[] {1, 2, 5, 10, 20, 50, 100, 200, 500}) initialLoad.put(denom, 10);

        int numberOfATMs = 3;
        int minWithdrawal = 10;
        int maxNotes = 10;

        bank.initializeATMs(numberOfATMs, minWithdrawal, maxNotes, initialLoad);
        System.out.println("Загальна сума коштів у мережі банкоматів: " + bank.getTotalFunds());

        ATM atm = bank.getATM(0);
        try {
            atm.deposit(50, 5);
            System.out.println("Після внесення депозиту, сума в банкоматі: " + atm.getTotalFunds());

            Map<Integer, Integer> dispensed = atm.withdraw(380);
            System.out.println("Зняття успішне. Видано купюри:");
            for (Map.Entry<Integer, Integer> entry : dispensed.entrySet()) System.out.println("Номінал: " + entry.getKey() + ", Кількість: " + entry.getValue());
            System.out.println("Залишок коштів у банкоматі: " + atm.getTotalFunds());
        } catch (ATMException e) {
            System.out.println("Помилка банкомату: " + e.getMessage());
        }
    }
}
