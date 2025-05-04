package book_example.chapter_1;

//Проверка, является ли строка палиндромом
//проверяем символы в строке начиная с первого и последнего, движимся к середине
public class Task_11 {

    public static boolean isPalindrome(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String str = "asbddbsad";
        System.out.println(isPalindrome(str));
    }
}
