package book_example.chapter_1;

//Удачение начальных и замыкающих пробелов (trim)
public class Task_21 {

    public static void main(String[] args) {

        String str = "\n  \n\n hello \t \n \r";
        System.out.println("after trim : " + str);
        String trimString = str.trim();
        System.out.println("before trim : " + trimString);
    }
}
