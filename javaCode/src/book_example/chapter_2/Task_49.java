package book_example.chapter_2;

//Немутируемые объекты в двух словах
public class Task_49 {

    public static final class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {

        Person person = new Person("Sergey", 30);
        System.out.println(person.getName());
    }
}
