package book_example.chapter_1;

//Вычисление целой части деления и целой части остатка от деления
public class Task_35 {
    public static void main(String[] args) {
        double z = (double) -222/14;
        System.out.println(Math.floor(z));
        System.out.println(-222/14);
        System.out.println((long)Math.ceil((222.0/14)));
    }
}
