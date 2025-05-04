package book_example.chapter_1;

import java.math.BigInteger;

//Конвертирование значения типа BigInteger в примитивный тип
public class Task_33 {

    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.valueOf(Long.MAX_VALUE);
        long aLong = bigInteger.longValue();
        System.out.println("aLong = " + aLong);
        int bInt = bigInteger.intValue();
        System.out.println("bInt = " + bInt);

        long nExactLong = bigInteger.longValueExact();
        int nExactInt = bigInteger.intValueExact();
        System.out.println("nExactLong = " + nExactLong);
        System.out.println("nExactInt = " + nExactInt);
    }

}
