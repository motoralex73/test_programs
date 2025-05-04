package book_example.chapter_2;

//Блоки инструкций
public class Task_57 {

    static String func() {

            String str = "1";
            switch (str) {
                case "1" -> {
                    System.out.println("this 1");
                    return "digital 1";
                }
                default -> {
                    return "0";
                }
            }
    }

    public static void main(String[] args) {
        func();
    }
}
