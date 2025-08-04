import java.util.Arrays;

public class AddInArrayOnePlusInEnd {
    /*
    * Есть массив из чисел, нужно из функции вернуть массив + 1 в конце, типа как добавили к числу
    * и разложили числа по элементам массива
    * */

    public static int[] returnArrayOnePlusInEnd(int[] arr) {
        for (int i = arr.length-1; i>0; i--) {
            if (arr[i] == 9) {
                arr[i] = 0;
            }
            else {
                if ( (arr[i] + 1) < 9) {
                    arr[i] = arr[i] + 1;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {1,2,9,9,5};
        System.out.println(Arrays.toString(returnArrayOnePlusInEnd(array)));
    }
}
