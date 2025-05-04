package book_example.chapter_1;

import java.util.stream.Stream;

//Трасформирование строк
public class Task_24 {

    public static void main(String[] args) {
        //1
        String resString = Stream.of("Hello")
                .map(s -> s + " world")
                .findFirst()
                .get();
        System.out.println(resString);
        //2
        String resString_2 = Stream.of("gooool! ")
                .map(String::toUpperCase)
                .map(s -> s.repeat(2))
                .map(s -> s.replaceAll("O","OOOO"))
                .findFirst()
                .get();
        System.out.println(resString_2);
        //3
//        String resString_3 = "hello".transform(s -> s + " world");
//        System.out.println(resString_3);
//        //4
//        String resString_4 = "gooool".transform(String::toUpperCase)
//                .transform(s -> s.repeat(5))
//                .transform(s -> s.replaceAll("O","OOOO"));
//        System.out.println(resString_4);
    }
}
