package lambda;

import java.util.Arrays;

public class LambdaException {

    static int mega;

    //Генерация исключения в лямбда-выражении
    interface DoubleNumericArrayFunction {
        double generateArraySummOrException(double[] n) throws EmptyArrayException;
    }

    static class EmptyArrayException extends Exception {
        EmptyArrayException() {
            super("Массив пуст");
        }
    }

    public static void main(String[] args) throws EmptyArrayException {

        double[] values = {1.0, 2.0, 3.0};
        DoubleNumericArrayFunction av = (n) -> {
            double sum = 0.0;
            mega = 100;
            System.out.println("Mega = " + mega);
            if (n.length == 0) throw new EmptyArrayException();
            for (double nn : n) sum += nn;
            return sum / n.length;
        };
        System.out.println("Из массива чисел : "+ Arrays.toString(values) + " среднее значение : " + av.generateArraySummOrException(values));
        //System.out.println(av.generateArraySummOrException(values));
    }
}
