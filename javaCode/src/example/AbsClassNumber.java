package example;

import static java.lang.Double.*;

public class AbsClassNumber {


    public static void main(String[] args) {
        Number number = 123;
        Double dbl = number.doubleValue();
        System.out.println(dbl);

        String s = "567";
        Double flt = valueOf(s);
        System.out.println(flt);
        Double dbl1 = valueOf("678");
        System.out.println(dbl1);
        Double dbl2 = valueOf(new String("34567"));
        System.out.println(dbl2);
        System.out.println(dbl2.byteValue() + " and 34567 % 256 = " + dbl2%256);
    }
}
