package book_example.chapter_2;

//Выражение switch
public class Task_55 {


    public static String main(String[] args) {
        String str = "1";
        switch (str) {
            case "1" -> {
                return "digital 1";
            }
            default -> {
                return "0";
            }
        }
    }
}
