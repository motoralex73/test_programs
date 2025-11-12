package patterns;

//Паттерн Фабрика (что-то производит похожее)
public class PatternsFactory {

    interface Car {
        void drive();
    }

    static class Toyota implements Car {
        @Override
        public void drive() {
            System.out.println("drive Toyota");
        }
    }

    static class Audi implements Car {
        @Override
        public void drive() {
            System.out.println("drive Audi");
        }
    }

    static class Factory {
        public Car create(String typeOfCar) {
            return switch (typeOfCar) {
                case "Toyota" -> new Toyota();
                case "Audi" -> new Audi();
                default -> null;
            };
        }
    }

    public static void main(String[] args) {

        Factory factory = new Factory();
        Car toyota = factory.create("Toyota");
        Car audi = factory.create("Audi");
        toyota.drive();
        audi.drive();
    }
}
