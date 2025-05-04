package book_example.chapter_1;

//Сравнение двух беззнаковых чисел
public class Task_29 {
    public static void main(String[] args) {
        int resultSigned = Integer.compare(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int resultUnsigned = Integer.compare(Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("signed = " + resultSigned + " unsigned = " + resultUnsigned);
    }
}
