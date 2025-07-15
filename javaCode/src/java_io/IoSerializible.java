package java_io;

import java.io.*;

public class IoSerializible {

    static class HelloClass implements Serializable {
        private String name;
        private int age;
        private double money;

        public HelloClass(String name, int age, double money) {
            this.name = name;
            this.age = age;
            this.money = money;
        }

        public String toString() {
            return "name = " + name + " age = " + age + " money = " + money;
        }
    }

    public static void main(String[] args) {

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream((new FileOutputStream("serial")))) {
            HelloClass hc = new HelloClass("Alex", 25, 1234567.45);
            System.out.println("out object: " + hc);
            objectOutputStream.writeObject(hc);
        } catch (IOException e) {
            System.out.println("Serialize exception: " + e);
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serial"))){
            HelloClass hc = (HelloClass) objectInputStream.readObject();
            System.out.println("in object: " + hc);
        } catch (Exception e) {
            System.out.println("Serialize exception: " + e);
        }
    }
}
