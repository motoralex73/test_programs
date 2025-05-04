package book_example.chapter_2;

import java.awt.*;

//Переопределение метода toString()
public class Task_54 {

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


    public static void main(String[] args) {
        Car car = new Car("bmw", Color.BLUE);
        System.out.println(car);
    }
}
