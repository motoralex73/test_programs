package book_example.chapter_1;

//Подсчет числа появлений подстроки в строке
public class Task_17 {

    public static void main(String[] args) {
        String text = "Hello, world!!! Hello my friend";
        String searchText = "ello";
        int position = 0;
        int count = 0;
        int n = searchText.length();

        while ( (position = text.indexOf(searchText, position)) !=-1 ) {
            position += n;
            count++;
        }
        System.out.println(count);
    }
}
