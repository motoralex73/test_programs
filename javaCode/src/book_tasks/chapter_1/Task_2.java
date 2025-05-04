package book_tasks.chapter_1;

//Отыскивание первого неповторяющегося символа
public class Task_2 {

    public static void main(String[] args) {
        String str = "ПППрррррривет, как дела?";
        char temp = '\0';
        boolean ok = false;
        for (int i = 0; i < str.length(); i++) {
            if (temp != str.charAt(i) && i > 0 && ok == false) {
                System.out.println(str.charAt(i+1));
                ok = true;
            }
            else {
                temp = str.charAt(i);
                ok = false;
            }
        }
    }
}
