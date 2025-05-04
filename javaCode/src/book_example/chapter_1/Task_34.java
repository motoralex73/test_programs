package book_example.chapter_1;

//Конвертирование значения типа long в значение типа int
public class Task_34 {
    public static void main(String[] args) {
        int intMax = Integer.MAX_VALUE;
        long longMax = Long.MAX_VALUE;
        int a = Math.toIntExact(intMax);
        System.out.println(a);
        int b = Math.toIntExact(longMax);
        System.out.println(b);
    }
}
