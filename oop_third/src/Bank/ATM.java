package Bank;

import java.util.*;

public class ATM {
    private Map<Integer, Integer> banknotes;
    private int minWithdrawal;
    private int maxNotes;

    public ATM(int minWithdrawal, int maxNotes) {
        this.minWithdrawal = minWithdrawal;
        this.maxNotes = maxNotes;
        banknotes = new TreeMap<>();
        for (int d : new int[] {1, 2, 5, 10, 20, 50, 100, 200, 500}) banknotes.put(d, 0);
    }

    public void loadMoney(Map<Integer, Integer> load) {
        for (Map.Entry<Integer, Integer> entry : load.entrySet()) {
            int denom = entry.getKey();
            int count = entry.getValue();
            if (banknotes.containsKey(denom)) banknotes.put(denom, banknotes.get(denom) + count);
        }
    }

    public void deposit(int denomination, int count) throws InvalidAmountException {
        if (!banknotes.containsKey(denomination)) throw new InvalidAmountException("Невірний номінал: " + denomination);
        if (count <= 0) throw new InvalidAmountException("Кількість повинна бути додатною");
        banknotes.put(denomination, banknotes.get(denomination) + count);
    }

    public Map<Integer, Integer> withdraw(int amount) throws ATMException {
        if (amount < minWithdrawal) throw new InvalidAmountException("Сума менша за мінімальну для видачі");

        int totalFunds = getTotalFunds();
        if (amount > totalFunds) throw new InsufficientFundsException("Недостатньо коштів у банкоматі");

        List<Integer> denominations = new ArrayList<>(banknotes.keySet());
        denominations.sort(Collections.reverseOrder());
        Map<Integer, Integer> result = new HashMap<>();

        int remaining = amount;
        int totalNotesUsed = 0;

        Map<Integer, Integer> tempBanknotes = new HashMap<>(banknotes);

        for (int denom : denominations) {
            int available = tempBanknotes.get(denom);
            int needed = remaining / denom;
            int use = Math.min(needed, available);
            if (use > 0) {
                result.put(denom, use);
                remaining -= use * denom;
                totalNotesUsed += use;
                tempBanknotes.put(denom, available - use);
            }
        }

        if (remaining != 0) throw new InsufficientFundsException("Неможливо видати точну суму з доступних купюр");

        if (totalNotesUsed > maxNotes) throw new ExceedMaxNotesException("Видано занадто багато купюр (максимум " + maxNotes + ")");

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            int denom = entry.getKey();
            int count = entry.getValue();
            banknotes.put(denom, banknotes.get(denom) - count);
        }

        return result;
    }

    public int getTotalFunds() {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : banknotes.entrySet()) total += entry.getKey() * entry.getValue();
        return total;
    }

    public void displayBanknotes() {
        System.out.println("Стан купюр у банкоматі:");
        for (Map.Entry<Integer, Integer> entry : banknotes.entrySet()) System.out.println("Номінал: " + entry.getKey() + ", Кількість: " + entry.getValue());
    }
}
