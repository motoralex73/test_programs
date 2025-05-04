package book_example.chapter_3;

import example.LocalDateClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//Конвертирование строки в дату и время
public class Task_58 {

    public static void main(String[] args) {
        String stringDate = "2024-11-23";
        String stringTime = "10:11:12";
        String stringTime_2 = "2024-11-23T10:11:12";

        LocalDate localDate = LocalDate.parse(stringDate);
        System.out.println(localDate.getYear());

        LocalTime localTime = LocalTime.parse(stringTime);
        System.out.println(localTime.getHour());

        LocalDateTime localDateTime = LocalDateTime.parse(stringTime_2);
        System.out.println(localDateTime.getHour());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateFormatted = LocalDate.parse("01.12.2023",dateTimeFormatter);
        System.out.println(localDateFormatted.getYear());

        DateTimeFormatter dateTimeFormatter_2 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDate localDateFormatted_2 = LocalDate.parse("01.12.2025 12:13:14",dateTimeFormatter_2);
        System.out.println(localDateFormatted_2.getYear());

        //Date to String
        String string = localTime.toString();
        System.out.println(string);
        System.out.println(localDateTime);
    }
}
