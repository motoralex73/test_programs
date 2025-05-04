package book_example.chapter_2;

import java.util.Objects;

//Проверка ссылок на null и выбрасывание собственного исключения NullPointerException
public class Task_41 {

    public static class Car {
        private final String name;
        private final String color;

        public Car(String name, String color) {
            this.name = Objects.requireNonNull(name, "Имя авто не может быть null");
            this.color = Objects.requireNonNull(color, "Цвет авто не может быть null");
        }

        public void assignDriver(String license, String location) {
            Objects.requireNonNull(license, "Лицензия не может быть null");
            Objects.requireNonNull(location, "Локация не может быть null");
        }
    }

    public static void main(String[] args) {

        new Car("Audi", null);
    }
}
