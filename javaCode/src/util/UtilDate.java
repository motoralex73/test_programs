package util;

import java.util.*;

public class UtilDate {

    public static void main(String[] args) {
        System.out.println(new Date());
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(Calendar.DATE));

    }
}
