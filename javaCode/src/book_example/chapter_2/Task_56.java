package book_example.chapter_2;

//Многочисленные метки вариантов
public class Task_56 {

    static String func() {
        String s = "hello";
        switch (s) {
            case "hello", "goodbye" -> {
                s = "hello - goodbye";
                System.out.println("block hello");
                break;
            }
            case "ok" -> {
                System.out.println("ok");
                break;
            }
        }

        System.out.println("before switch");

        return s;
    }

    public static void main(String[] args) {

        System.out.println(func());
    }
}
