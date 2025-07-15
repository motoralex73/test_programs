package example;

public class ExampleRecord {

    record People(String name, int age) {
        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return "People has name = " + name + ", age = " + age;
        }
    }

    public static void main(String[] args) {
        People[] people = new People[4];
        people[0] = new People("Alex",38);
        for (People p : people) System.out.println(p);
    }
}
