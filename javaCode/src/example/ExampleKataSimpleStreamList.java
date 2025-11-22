package example;

import java.util.List;

public class ExampleKataSimpleStreamList {
    public static void main(String[] args) {
        var listNumber = List.of(1,2,3,4,5,6,7,8,9);
        var sortedList = listNumber.stream().filter(a -> a % 2 != 0).toList();
        System.out.println(sortedList);
    }

}
