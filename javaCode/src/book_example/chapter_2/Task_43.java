package book_example.chapter_2;

import java.awt.*;
import java.util.Objects;

//Проверка ссылок на null и возврат непустых ссылок, заданных по умолчанию
public class Task_43 {

    static public class Car {
        private final String name;
        private final Color color;

        @Override
        public String toString() {
            return "Car name='" + name + '\'' + ", color=" + color;
        }

        public Car(String name, Color color) {

            if (name == null) {
                this.name = "Безымянный";
            }
            else {
                this.name = name;
            }
            if (color == null) {
                this.color = new Color(0,0,0);
            }
            else {
                this.color = color;
            }
        }
    }

    static public class Car_2 {
        private final String name;
        private final Color color;

        @Override
        public String toString() {
            return "Car name='" + name + '\'' + ", color=" + color;
        }

        public Car_2(String name, Color color) {
            this.name = Objects.requireNonNullElse(name,"No name");
            this.color = Objects.requireNonNullElseGet(color, () -> new Color(0,0,0));
        }
    }

    public static void main(String[] args) {
        Car car = new Car("Bmw", new Color(255,0,0));
        System.out.println(car);
        Car_2 car_2 = new Car_2(null, new Color(0,255,0));
        System.out.println(car_2);
    }
}
