package book_example.chapter_1;

import javax.swing.text.NumberFormatter;

//Компактное форматирование чисел
public class Task_39 {
    public static void main(String[] args) {
        double number = 3678.5; // Исходное число
        System.out.println("Число: " + number);
        // Округление до ближайшего кратного 1000
        long roundedToNearest1000 = Math.round(number / 1000) * 1000;
        System.out.println("Округление до ближайшего значения кратного 1000: " + roundedToNearest1000);
    }
}
