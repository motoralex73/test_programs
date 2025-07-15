package util;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class UtilFormatter {
    public static void main(String[] args) {

        //1
        Formatter formatter = new Formatter();
        formatter.format("Форматирование string = %s int = %d float = %3.5f hex = %#X oct = %o", "строка", 10, 11.12, 254, 123);
        String s = formatter.toString();
        System.out.println(s);
        formatter.close();
        //2
        Calendar calendar = Calendar.getInstance();
        formatter = new Formatter();
        formatter.format("%tr",calendar);
        System.out.println(formatter);
        formatter.close();
        //3
        System.out.println(new Formatter().format("%3$d %1$d %2$d", 10,20,30));
        System.out.println(new Formatter().format("%d в hex-виде = %<x в oct-виде = %<o",255));
        System.out.println(new Formatter().format("Сегодня дата: день = %te месяц = %<tB год = %<tY",calendar));
    }
}
