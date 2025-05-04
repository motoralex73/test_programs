package book_example.chapter_1;

//Соединение нескольких строк
public class Task_9 {

    static String str1 = "Hello,";
    static String str2 = " my ";
    static String str3 = "friend!";

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1 + str2 + str3);
        System.out.println(stringBuilder);
    }
}
