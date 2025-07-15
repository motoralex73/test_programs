package example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class AnnotationExample {

    @Retention(RetentionPolicy.RUNTIME)
    @interface Anno {
        String str() default "Стандартный текст";
        int val() default 1000;
    }

    //@Anno()
    @Anno(str = "Пример аннотации", val = 100)
    public static void func() {
        try {
            var ob = new AnnotationExample();
            Class<?> c = ob.getClass();
            Method m = c.getMethod("func");
            Anno anno = m.getAnnotation(Anno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        func();
    }
}
