package sobes_tasks;

import java.util.HashMap;

public class Shortcat_task_1 {
    public static void main(String[] args) {
        int[] banknotes = {100, 500, 1000};
        int amount = 13700;
        var result = minBanknotes(banknotes, amount);
        if (result == null) {
            System.out.println("Невозможно составить сумму: " + amount);
        } else System.out.println("Минимальный набор банкнот для суммы: " + amount + ", список номиналов: " + result);
    }

    private static HashMap<Integer, Integer> minBanknotes(int[] banknotes, int amount) {
        var resultMap = new HashMap<Integer, Integer>();
        for (int i = banknotes.length - 1; i >= 0; i--) {
            if (banknotes[i] <= amount) {
                System.out.println(amount);
                int count = amount/banknotes[i];
                amount %= banknotes[i];
                resultMap.put(banknotes[i], count);
            }
            else return resultMap;
        }
        return resultMap;
    }
}
