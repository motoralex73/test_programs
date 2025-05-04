package book_example.chapter_1;

//Удаление повторяющихся символов
public class Task_12 {

    public static String deleteDublicate(String str) {

        StringBuilder stringBuilder = new StringBuilder();

        char temp = '\0';
        for (int i = 0; i < str.length(); i++) {
            if (temp != str.charAt(i)) stringBuilder.append(str.charAt(i));
            temp = str.charAt(i);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "ППППППриииииввет, как твоооои деллллааа?";
        System.out.println(deleteDublicate(str));
    }
}
