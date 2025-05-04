package book_example.chapter_1;

//Отыскивание первого неповторяющегося числа
public class Task_2 {

    public static void main(String[] args) {
        String str = "ПППррррррривет";
        char temp = '\0';
        if (!str.isEmpty())
        for (int i = 0; i < str.length(); i++) {
                if (
                        (i > 0 && str.charAt(i) != temp && str.charAt(i) != str.charAt(i+1) ) ||
                        (str.length() > 1 && str.charAt(0) != str.charAt(1) ) ||
                        ( (str.length() >= 2) && (str.length() < 3)  && (str.charAt(str.length() - 1) != str.charAt(str.length() - 2)) )
                )
                {
                    System.out.println(str.charAt(i));
                    break;
                }
                temp = str.charAt(i);
        }
    }
}
