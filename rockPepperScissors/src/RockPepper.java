import java.io.IOException;
import java.util.Scanner;

public class RockPepper {

    public static void main(String[] args) throws IOException {
        //while (true)
        {

            System.out.println("Выберите: \nкамень = 0, \nножницы = 1, \nбумага = 2, \nвыход = q");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            switch (s) {
                case "0" :
                    System.out.println("Камень");
                    break;
                case "1" :
                    System.out.println("Ножницы");
                    break;
                case "2" :
                    System.out.println("Бумага");
                    break;
                case "q" :
                    System.out.println("Выход");
                    return;
                default:
                    System.out.println("Неизвестный параметр");
                    break;
            }

            System.out.println("Комп рандомно выбрал:");
            
        }
    }





}
