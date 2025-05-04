package book_example.chapter_2;

import java.lang.reflect.Field;

//Немутируемая строка
public class Task_48 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        String user = "guest";
        System.out.println("Type user = " + user);

        Class<String> type = String.class;
        Field field = type.getDeclaredField("value");
        field.setAccessible(true);

        char[] chars = (char[]) field.get(user);
        chars[0] = 'a'; chars[1] = 'd'; chars[2] = 'm'; chars[3] = 'i'; chars[4] = 'n';
        System.out.println(user);
    }
}
