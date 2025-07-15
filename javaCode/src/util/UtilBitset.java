package util;

import java.util.BitSet;

public class UtilBitset {
    public static void main(String[] args) {
        BitSet b1 = new BitSet(16);
        BitSet b2 = new BitSet(16);
        for (int i=0; i<16; i++) {
            if (i % 2 == 0) b1.set(i);
            if (i % 5 != 0) b2.set(i);
        }
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        b2.and(b1);
        System.out.println("b2 and b1 = " + b2);
        b2.or(b1);
        System.out.println("b2 or b1 = " + b2);
        b2.xor(b1);
        System.out.println("b2 xor b1 = " + b2);
    }
}
