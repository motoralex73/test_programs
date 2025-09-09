package example;

public interface ExampleInterface {
    default void hello() { //дефолтный метод
        System.out.println("Hello World");
    }
    static void staticMethod() { //статический метод
        System.out.println("Static Method");
    }
    void reservationMethod(); //абстрактный метод
}
