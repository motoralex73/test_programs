package book_example.chapter_1;

//Удаление заданного символа и повторяющие пробелы
public class Task_13 {

    public static void main(String[] args) {

        String str = "Удаление ,, заданного ,,        символа";
        StringBuilder strClear = new StringBuilder();
        char ch = ',';
        char deleteGap = '\0'; //удаляем повторяющиеся пробелы
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch && str.charAt(i) != deleteGap ) {
                strClear.append(str.charAt(i));
                deleteGap = '\0';
            }
            if (str.charAt(i) == ' ') deleteGap = str.charAt(i);
        }
        System.out.println(strClear);
    }
}
