package book_example.chapter_1;

import java.util.function.BinaryOperator;

//Вычисление минимума и максимума двух чисел
public class Task_25 {

    public static void main(String[] args) {

        double d1 = 1.234567D;
        double d2 = 2.345678D;

        double minDouble = Double.min(d1,d2);
        double maxDouble = Double.max(d1,d2);

        System.out.println("double min = " + minDouble + " max = " + maxDouble);

        float f1 = 1.23F;
        float f2 = 2.34F;

        float minFloat = Float.min(f1,f2);
        float maxFloat = Float.max(f1,f2);

        System.out.println("float min = " + minFloat + " max = " + maxFloat);

        double maxFloatOrDouble = Math.max(f1,d1);
        System.out.println("maxFloatOrDouble = " + maxFloatOrDouble);

        float minFloatOrDouble = BinaryOperator.minBy(Float::compare).apply(f2,(float)d2);
        System.out.println("minFloatOrDouble = " + minFloatOrDouble);
    }
}
