package java_io;

import java.io.FileOutputStream;
import java.io.IOException;

//Потоки записи массивов байт (из string)
public class IoFileOutputStream {
    public static void main(String[] args) {
        String s = "Пришла пора"+ " нам с юностью прощаться";
        byte[] buf = s.getBytes();
        // try с ресурсами
        try(
                FileOutputStream f1 = new FileOutputStream("file1.txt");
                FileOutputStream f2 = new FileOutputStream("file2.txt");
                FileOutputStream f3 = new FileOutputStream("file3.txt");
        ) {
            for (byte b : buf) f1.write(b);
            f2.write(buf);
            f3.write(buf, buf.length - buf.length/4, buf.length/4);
        } catch (IOException e) {
            System.out.println("Error write-read");
        }
    }
}
