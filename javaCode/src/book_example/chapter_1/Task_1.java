package book_example.chapter_1;

//подсчет повторяющихся символов
public class Task_1 {
    public static void main(String[] args) {

        String str = "Приииивет, как делллллллла?";
        char temp = '\0';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i != 0 && temp == str.charAt(i)) count++;
            else {
                if (count > 1) System.out.println(temp + " = " + ++count);
                temp = str.charAt(i);
                count = 0;
            }
        }
    }
}
