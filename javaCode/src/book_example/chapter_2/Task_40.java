package book_example.chapter_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Проверка ссылок на null в функциональном и императивном стилях программирования
public class Task_40 {

    static List<Integer> numbers = Arrays.asList(1,2,null,4,null,16,7,null);

    static List<Integer> evenIntegers(List<Integer> integers) {

        if (integers == null) return Collections.EMPTY_LIST;
        List<Integer> events = new ArrayList<>();
        for (Integer nr : integers) {
            if (nr != null)  events.add(nr);
        }
        return events;
    }

    public static void main(String[] args) {
        System.out.println(evenIntegers(numbers));
    }
}
