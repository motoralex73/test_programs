package book_example.chapter_1;

//Конвертирование строки в значение типа int, long, float или double.
public class Task_7 {

    public static void main(String[] args) {

        int i = Integer.parseInt("123");
        System.out.println(i);
        long l = Long.parseLong("567");
        System.out.println(l);
        float f = Float.valueOf("123.45");
        System.out.println(f);
        double d = Double.valueOf("456.78");
        System.out.println(d);
    }
}
