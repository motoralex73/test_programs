package java_io;

import java.io.ByteArrayInputStream;

public class IoByteArrayInputStream {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        byte[] b = s.getBytes();
        ByteArrayInputStream input1 = new ByteArrayInputStream(b);
        ByteArrayInputStream input2 = new ByteArrayInputStream(b,0,5);
        System.out.println(input1);
        System.out.println(input2);
    }
}
