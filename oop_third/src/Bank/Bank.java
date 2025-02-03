package Bank;

import java.util.*;

public class Bank {
    private List<ATM> atms;

    public Bank() { atms = new ArrayList<>(); }

    public void initializeATMs(int numberOfATMs, int minWithdrawal, int maxNotes, Map<Integer, Integer> initialLoad) {
        for (int i = 0; i < numberOfATMs; i++) {
            ATM atm = new ATM(minWithdrawal, maxNotes);
            atm.loadMoney(initialLoad);
            atms.add(atm);
        }
    }

    public int getTotalFunds() {
        int total = 0;
        for (ATM atm : atms) total += atm.getTotalFunds();
        return total;
    }

    public ATM getATM(int index) {
        if (index < 0 || index >= atms.size()) return null;
        return atms.get(index);
    }
}
