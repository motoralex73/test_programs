package exceptions;

//Исключение при обращении к null-объекту
public class Example_NullPointerException {
    public static void main(String[] args) {
        String string = null;
        try {
            System.out.println(string.length());
        }
        catch (NullPointerException e) {
            System.out.println("Message exception: " + e.getMessage());
        }
        finally {
            System.out.println("Message finally block");
        }
    }
}
