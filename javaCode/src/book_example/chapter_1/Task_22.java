package book_example.chapter_1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

//Поиск наибольшего общего префикса
public class Task_22 {

    public static void main(String[] args) {

        String[] strings = {"abc","abcd", "abcde", "ab", "abcd", "abcdef"};
        Set<Character> set = new LinkedHashSet<>();
        int countLetters = strings[0].length();

        for (int i = 0; i < Arrays.stream(strings).count(); i++) {
            if (countLetters > strings[i].length()) countLetters = strings[i].length();
        }

        System.out.println(countLetters);

        if (strings[0].length() > 0) {
            for (int i = 0; i < countLetters; i++) {
                System.out.println("--------------");
                for (int j = 0; j < Arrays.stream(strings).count(); j++) {
                    if (strings[j].charAt(i) == strings[0].charAt(i)) {
                        set.add(strings[0].charAt(i));
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character s : set) stringBuilder.append(s);
        System.out.println("Итоговый префикс всех строк = " + stringBuilder);
    }
}
