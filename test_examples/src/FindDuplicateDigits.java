import java.util.*;

public class FindDuplicateDigits {

    static int[] mas = {1,2,3,4,4,5,5,5,6,7,8,9,9,9,9,9,11};

    public static void main(String[] args) {
        Map<Integer, Integer> duplicate = new HashMap<>();
        int count = 1;
        for (int i = 0; i < mas.length; i++) {
            if (i > 0 && mas[i] == mas[i-1]) {
                duplicate.put(mas[i], ++count);
            }
            else count = 1;
        }
        System.out.println(duplicate);
    }
}
