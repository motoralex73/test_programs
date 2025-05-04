package example;

import java.lang.reflect.Field;

public class Reflaction {

    static class MyClass {
        public int number = 42;
        protected String text = "Hello, world!";
        private double pi = Math.PI;
    }

    private static void printFields(Object object) throws IllegalAccessException {
        Class<?> c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println("Field: " + field.getName());
            System.out.println("Type: " + field.getType().getName());
            System.out.println("Value: " + field.get(object));
        }
    }

    public static void main(String[] args) throws IllegalAccessException {

        MyClass o = new MyClass();
        printFields(o);
    }
}
