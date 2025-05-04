package book_example.chapter_1;

//Проверка, содержит ли строковое значение только цифры
public class Task_4 {

    //если в строке содержится хотя бы один не числовой символ
    static boolean onlyDigits_1(String str) {
        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }

    static boolean onlyDigits_2(String str) {
        return str.matches("[0-9]+");
    }

    public static void main(String[] args) {
        String str = "12345hello";
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) System.out.println(str.charAt(i) + " -> not digits");
        }

        System.out.println(onlyDigits_1(str));
        System.out.println(onlyDigits_2(str));
    }
}
