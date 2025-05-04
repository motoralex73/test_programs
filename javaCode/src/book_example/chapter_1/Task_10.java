package book_example.chapter_1;

//Генерирование всех перестановок
public class Task_10 {

    private static void permuteAndPrint(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix + " ");
        else {
            for (int i = 0; i < n; i++) {
                permuteAndPrint(prefix + str.charAt(i), str.substring(i+1, n) + str.substring(0, i));
            }
        }
    }

    public static void main(String[] args) {

        String str = "ABC";
        permuteAndPrint("", str);

    }
}
