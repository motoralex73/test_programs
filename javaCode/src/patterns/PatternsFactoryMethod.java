package patterns;

//Паттерн Фабричный метод, метод для создания объекта класса (бина)
public class PatternsFactoryMethod {

    public static class Person {
        private Person() {}
        public static Person create() {
            return new Person();
        }

        @Override
        public String toString() {
            return "Person class";
        }
    }

    public static void main(String[] args) {
        Person person = Person.create();
        System.out.println(person);
    }
}
