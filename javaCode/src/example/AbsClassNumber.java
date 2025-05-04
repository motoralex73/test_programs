package example;

import static java.lang.Double.*;

public class AbsClassNumber {


    public static void main(String[] args) {
        Number number = new Integer(123);
        Double dbl = number.doubleValue();
        System.out.println(dbl);

        Float flt = new Float("567");
        System.out.println(flt);
        Double dbl1 = new Double("678");
        System.out.println(dbl1);
        Double dbl2 = valueOf(new String("34567"));
        System.out.println(dbl2);
        System.out.println(dbl2.byteValue() + " and 34567 % 256 = " + dbl2%256);

    }
}
