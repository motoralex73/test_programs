package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UtilScanner {

    static void ex() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter digits:");
        Integer sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                System.out.println(sum);
            }
            else {
                String s = scanner.next();
                if (s.equals("exit")) break;
                else {
                    System.out.println("Any text");
                    return;
                }
            }
        }
    }

    static void ex_2() throws IOException {
        int count = 0;
        double sum = 0.0;
        FileWriter fout = new FileWriter("test.txt");
        fout.write("1,  2,3.5,   7.7, 10, done");
        fout.close();
        FileReader fin = new FileReader("test.txt");
        Scanner scanner = new Scanner(fin);
        scanner.useDelimiter(", *");
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
                count++;
            }
            else {
                String s = scanner.next();
                if (s.equals("done")) break;
                else {
                    System.out.println("Unknown text");
                    return;
                }
            }
        }
        scanner.close();
        System.out.println("sum = " + sum/count);
    }

    static void ex_3() {
        String text = "Name: Tom Hanks Age: 77 ID: 123";
        Scanner scanner = new Scanner(text);
        scanner.findInLine("Age:");
        if (scanner.hasNext()) System.out.println(scanner.next());
        else System.out.println("Error");
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        ex_3();
    }
}
