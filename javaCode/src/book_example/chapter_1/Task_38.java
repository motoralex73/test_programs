package book_example.chapter_1;

//Совмещенное умножение-сложение
public class Task_38 {

    public static void main(String[] args) {
        double x = 49.29d;
        double y = -28.58d;
        double z = 33.63d;
        double q = (x * y) + z;
        System.out.println(q);
        System.out.println(Math.fma(x,y,z));
    }
}
