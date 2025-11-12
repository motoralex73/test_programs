package example;

public class ExampleRecord {

    record People(String name, int age) {
         public String toString() {
            return "People has name = " + name + ", age = " + age;
        }
    }

    public static void main(String[] args) {
        People[] people = new People[4];
        people[3] = new People("Alex",38);
        for (People p : people) System.out.println(p);
    }
}
