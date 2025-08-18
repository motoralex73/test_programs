package exceptions;

//Выход за границы массива
public class Example_ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        try {
            System.out.println(array[10]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Message exception: " + e.getMessage());
        }
    }
}
