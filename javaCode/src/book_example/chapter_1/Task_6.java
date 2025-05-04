package book_example.chapter_1;

import java.util.Collections;

//Подсчет появления некоторого символа
public class Task_6 {

    public static void main(String[] args) {

        //1
        int count = 0;
        char ch = 'a';
        String str = "Hello, my friend. How are you? aaa";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) count++;
        }
        System.out.println(count);

        //2
        System.out.println(
                str.chars().filter(c -> c == ch).count()
        );




    }
}
