import java.util.Arrays;

public class AddInArrayOnePlusInEnd {
    /*
    * Есть массив из чисел, нужно из функции вернуть массив + 1 в конце, типа как добавили к числу
    * и разложили числа по элементам массива
    * */

    public static int[] returnArrayOnePlusInEnd(int[] arr) {
        int next = 0;
        for (int i = arr.length-1; i>0; i--) {
            if (arr[i] < 9) {
                arr[i] = arr[i]+1;
                return arr;
            }
            else {
                if (next > 0) arr[i] = next;
                next = arr[--i] + 1;
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,9,9};
        System.out.println(Arrays.toString(returnArrayOnePlusInEnd(array)));
    }
}
