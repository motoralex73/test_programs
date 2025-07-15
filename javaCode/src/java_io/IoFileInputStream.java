package java_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

//Чтение из файла
public class IoFileInputStream {


    public static void main(String[] args) throws FileNotFoundException {
        int size;
        try (FileInputStream f = new FileInputStream("test.txt")) {
            System.out.println(f.available());
            System.out.println(Arrays.toString(f.readNBytes(4)));

        } catch (Exception e) {
            throw new FileNotFoundException("file not found, look her name");
        }
        finally {
            System.out.println("finally");
        }
    }
}
