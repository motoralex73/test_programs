package example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Reflaction {

    static class MyClass {
        public int number = 42;
        protected String text = "Hello, world!";
        private double pi = Math.PI;
        void say(String s) {
            System.out.println("Say this: " + s);
        }
        void say2(String s) {
            System.out.println("Say this v2: " + s);
        }
    }

    private static void printClassFieldsAndParameters(Object object) throws IllegalAccessException, InvocationTargetException {
        Class<?> c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("pi")) field.setDouble(object,5.55555);

            System.out.println("field Field: " + field.getName());
            System.out.println("field Type: " + field.getType().getName());
            System.out.println("field Value: " + field.get(object));
        }
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            method.invoke(object,"invoke method say()");

            System.out.println("method name: " + method.getName());
            System.out.println("method parameters type: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("method modifier: " + method.getModifiers());

            Parameter[] parameters = method.getParameters();
            for (Parameter p : parameters) {
                System.out.println("Parameter name: " + p.getName());
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        MyClass o = new MyClass();
        printClassFieldsAndParameters(o);
    }
}
