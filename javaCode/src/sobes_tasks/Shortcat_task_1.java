package sobes_tasks;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Shortcat_task_1 {
    public static void main(String[] args) {
        int[] banknotes = {50, 100, 500, 1000};
        int amount = 13799;
        var result = minBanknotes(banknotes, amount);
        if (result == null) {
            System.out.println("Невозможно составить сумму: " + amount);
        } else System.out.println("Минимальный набор банкнот для суммы: " + amount + ", список номиналов: " + result);
    }

    private static HashMap<Integer, Integer> minBanknotes(int[] banknotes, int amount) {
        var resultMap = new LinkedHashMap<Integer, Integer>();
        int startAmount = amount;
        System.out.println("Запрашиваемая сумма = " + startAmount);
        for (int i = banknotes.length - 1; i >= 0; i--) {
            if (banknotes[i] <= amount) {
                int count = amount/banknotes[i];
                amount %= banknotes[i];
                resultMap.put(banknotes[i], count);
                if (amount < 50 && amount > 0) System.out.println("Мы выдали Вам сумму кратную миним. номиналу купюр = "+(startAmount - amount));
            }
            else return resultMap;
        }
        return resultMap;
    }
}
