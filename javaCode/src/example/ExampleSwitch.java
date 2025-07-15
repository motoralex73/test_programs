package example;

import java.util.Scanner;

public class ExampleSwitch {

    public void main(String[] args) throws Exception {
        int code = 0;
        Scanner scanner = new Scanner(System.in);

        try {
            code = scanner.nextInt();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
            code = 404;
        }

        String s = switch (code) {
            case 1, 2, 3 -> "simple";
            case 10, 11, 12, 404 -> (this + " or Exception 404");
            case 1001, 1000 -> "1000";
            case -1 -> "error";
            default -> {
                String ss = "hello";
                ss += " world";
                yield ss; //look this yield
            }
        };
        System.out.println(s);
    }
}
