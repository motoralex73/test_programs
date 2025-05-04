package book_example.chapter_3;

import java.text.SimpleDateFormat;
import java.util.Date;

//Форматирование даты и времени
public class Task_59 {

    public static void main(String[] args) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        String stringDate = format.format(new Date());
        System.out.println(stringDate);

        

    }
}
