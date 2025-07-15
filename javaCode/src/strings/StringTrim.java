package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTrim {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));
        String str = "";
        System.out.println("Для завершения введите стоп");
        System.out.println("Введите название штата: ");
        do {
            str = br.readLine();
            str = str.trim();
            switch (str) {
                case "Illinoyz" -> System.out.println("Столица Спрингфилд");
                case "Missuri" -> System.out.println("Столица Джефферсон");
                case "California" -> System.out.println("Столица Сакраменто");
            }
        }
        while (!str.equals("stop"));
    }
}
