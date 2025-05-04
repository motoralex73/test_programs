package book_example.chapter_1;

//Удаление пробелов из строки
public class Task_8 {

    public static void main(String[] args) {
        String strSource = "Привет  ,   как дела?   ";
        String str = strSource.replaceAll("\\s", "");
        System.out.println(str);
    }
}
