package exceptions;

//Пользовательское исключение
public class Example_CustomException {
    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            throw new CustomException("My custom exception");
        } catch (CustomException e) {
            System.out.println("Message my custom exception: " + e.getMessage());
        }
    }
}
