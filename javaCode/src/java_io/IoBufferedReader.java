package java_io;

import java.io.*;

public class IoBufferedReader {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line = "";
            while ((line = br.readLine()) != null) System.out.println(line);
        }
        catch (IOException e) {
            System.out.println("Error read");
        }
    }
}
