package book_example.chapter_1;

//Значение типа double/float являются конечным значением с плавающей точкой
public class Task_31 {
    public static void main(String[] args) {
        System.out.println(Float.isFinite(4.5f/0));
        System.out.println(Double.isFinite(0.123));
    }
}
