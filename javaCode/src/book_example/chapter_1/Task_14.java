package book_example.chapter_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Отыскивание символа с наибольшим числом появлений
public class Task_14 {

    public static int searchMaxCountDigit(String str) {
        Integer max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        Character character;

        for (int i = 0; i < str.length(); i++) {
            character = str.charAt(i);
            if (map.containsKey(character)) {
                int count = map.get(character);
                count++;
                map.put(character, count);
            }
            else map.put(character, 1);
        }

        System.out.println("Map со всеми символами и их количеством: " + map);
        for (Integer val : map.values()) {
            if (val > max) {
                max = val;
            }
            else System.out.print(val + " ");
        }
        System.out.println();

        //Достаем ключ по значению
        Integer finalMax = max;
        Character maxChar = map.entrySet().stream().filter(e -> e.getValue() == finalMax).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println("Самый частый символ: " + maxChar + " = " + max);

        return max;
    }

    public static void main(String[] args) {

        String str = "Отыскивание символа с наибольшим числом появлений";
        searchMaxCountDigit(str);
    }
}
