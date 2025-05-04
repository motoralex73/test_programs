package example;

//Задача найти потерянное число из последовательности чисел в массиве.
public class FindingLostNumber {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,6,7,8,9};
        int lostNumber = 0;
        for (int i=array[0], j=0; i<array.length; i++, j++) {
            if (i == array[j]) lostNumber = 0;
            else {lostNumber = array[j] - 1; break;}
        }
        System.out.println(lostNumber);
    }
}
