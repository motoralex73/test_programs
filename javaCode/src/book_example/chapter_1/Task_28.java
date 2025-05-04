package book_example.chapter_1;

//Конвертирование в число посредством беззнаковой конверсии
public class Task_28 {
    public static void main(String[] args) {
        int res1 = Short.toUnsignedInt(Short.MIN_VALUE);
        int res2 = Short.toUnsignedInt(Short.MAX_VALUE);
        System.out.println("min = " + res1 + ", max = " + res2);
    }
}
