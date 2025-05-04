package book_example.chapter_1;

import java.util.Arrays;

//Проверка, являются ли две строки анаграммами (строки, в которых одинаковые символы расположены по-разному)
public class Task_18 {


    static boolean testAnagramString(String s1, String s2) {

        s1 = s1.toLowerCase();
        char[] arrS1 = s1.toCharArray();
        Arrays.sort(arrS1);
        char[] arrS2 = s2.toLowerCase().toCharArray();
        Arrays.sort(arrS2);

        if (Arrays.equals(arrS1,arrS2)) return true;

        return false;
    }

    public static void main(String[] args) {

        String s1 = "HeLlo";
        String s2 = "lleoh";

        System.out.println("Strings (arrays) anagram is : " + testAnagramString(s1, s2));

        String ss1 = "HELLO";
        String ss2 = "HELLO";
        System.out.println(ss1 == ss2);
    }
}
