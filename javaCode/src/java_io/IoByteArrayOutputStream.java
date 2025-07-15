package java_io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class IoByteArrayOutputStream {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.printf("%d\n",123);
        PrintWriter printWriter = new PrintWriter("string");
        String s = printWriter.printf("HELLO").toString();
        System.out.println(s);
    }
}
