package book_example.chapter_1;

//Умножение двух крупных значений типа int/long и переполнение операции
public class Task_37 {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int y = x * x;
        System.out.println(y);

        long x1 = Integer.MAX_VALUE;
        long y1 = x1 * x1;
        System.out.println(y1);

        long x2 = Long.MAX_VALUE;
        long y2 = x2 * x2;
        System.out.println(y2);

        System.out.println(Math.multiplyExact(x2,x2));

        System.out.println(Math.multiplyFull(x,x));
    }
}
