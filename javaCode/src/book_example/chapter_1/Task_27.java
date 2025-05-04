package book_example.chapter_1;

//Строка как беззнаковое число системы счисления
public class Task_27 {
    public static void main(String[] args) {
        String nri = "255555";
        int result = Integer.parseUnsignedInt(nri);
        System.out.println(result);
    }
}
