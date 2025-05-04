package book_example.chapter_1;

import java.util.Arrays;
import java.util.Comparator;

//Сортировка массива строк по длине
public class Task_15 {

    public static void comparisonLengthStrings(String[] strings) {

        int len = 0, maxLen = 0;
        for (int i=0;i<3;i++) {
            if (len > strings[i].length()) maxLen = len;
            else maxLen = strings[i].length();
            len = strings[i].length();
            System.out.println("len = " + len);
        }
        System.out.println("maxLen = " + maxLen);
    }

    public static void main(String[] args) {

        String[] strings = {"Hello, people","Have a nice day","Where are you from?"};
        comparisonLengthStrings(strings);
    }
}
