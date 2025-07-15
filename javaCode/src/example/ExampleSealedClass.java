package example;

public class ExampleSealedClass {

    public static final class Alpha extends Gamma {
        int id;
    }
    //распечатанный подкласс
    public static non-sealed class Betta extends Gamma {
        String name;
    }
    //запечатанный класс
    public sealed static class Gamma permits Alpha, Betta {
        void showHello() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        Alpha a = new Alpha();
        a.showHello();
    }
}
