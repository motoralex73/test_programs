package exceptions;

//Обработка нескольких исключений
public class Example_ManyException {
    public static void main(String[] args) {
        try {
            int[] array = {1, 2, 3};
            System.out.println(array[10]);
            array[10] = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Any Exception: " + e.getMessage());
        }
        finally {
            System.out.println("Finally block");
        }
    }
}
