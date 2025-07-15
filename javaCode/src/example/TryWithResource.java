package example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//пример:
//try(FileInputStream fin = new FileInputStream(args[0]))
public class TryWithResource {

    public static void main(String[] args) {
        FileInputStream fin;
        int i;
        try {
            fin = new FileInputStream("text.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось открыть файл");
            return;
        }
        try {
            do {
                i = fin.read();
                if (i != -1) System.out.println((char)i);
            }
            while (i != -1);
        }
        catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
        try {
            fin.close();
        } catch (IOException e) {
            System.out.println("Ошибка при закрытии файла");
        }
    }
}
