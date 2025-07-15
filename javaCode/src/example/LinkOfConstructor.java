package example;

public class LinkOfConstructor {

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class MyClass<T> {

        private final T t;
        public MyClass(T t) {
            this.t = t;
        }
        void showT() {
            System.out.println(t.toString());
        }
    }

    interface MyInterface {
        MyClass linkMyClass(Person person);
    }

    public static void main(String[] args) {

        MyInterface mi = MyClass::new;
        Person person = new Person("Alex",38);
        MyClass mc = mi.linkMyClass(person);
        mc.showT();
    }
}
