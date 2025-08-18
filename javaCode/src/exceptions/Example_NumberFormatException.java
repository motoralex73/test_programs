package exceptions;

//Неверное преобразование строки
public class Example_NumberFormatException {
    public static void main(String[] args) {
        String input = "abc";

        try {
            int num = Integer.parseInt(input); // NumberFormatException
            System.out.println("Число: " + num);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: строка не является числом!");
        }
    }
}
