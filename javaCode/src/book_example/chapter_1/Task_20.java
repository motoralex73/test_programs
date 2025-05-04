package book_example.chapter_1;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Конкатенирование одной и той же строки n-раз
public class Task_20 {

    public static void concatString(String str, int count) {
        StringBuilder stringBuilder = new StringBuilder(str.length() * count);
        for (int i = 0; i < count; i++) {
            stringBuilder.append(str);
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        //1 func
        String str = "hello";
        concatString(str,10);
        //2 repeat
        String str1 = "Repeat".repeat(15);
        System.out.println(str1);
        //3 concat
        String str2 = "hellllo".concat("Concat");
        System.out.println(str2);
        //4 string join
        String str3 = String.join("", Collections.nCopies(5, "Join"));
        System.out.println(str3);
        //5 collect
        String str4 = Stream.generate(() -> "Generate").limit(5).collect(Collectors.joining());
        System.out.println(str4);
        //6 replace
        String str5 = String.format("%0" + 5 + "d", 0).replace("0", "Replace");
        System.out.println(str5);
        //7 replace
        String str6 = new String(new char[5]).replace("\0", "Replace-2");
        System.out.println(str6);
    }
}
