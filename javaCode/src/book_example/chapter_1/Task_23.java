package book_example.chapter_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Применение отступа, String.indent
public class Task_23 {

    public static void main(String[] args) {

        String days = "Sunday\n"
                + "Monday\n"
                + "Tuesday\n"
                + "Wednesday\n"
                + "Thursday\n"
                + "Friday\n"
                + "Saturday\n";

        System.out.print(days);
        List<String> list = Arrays.asList("Sunday","Monday");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
