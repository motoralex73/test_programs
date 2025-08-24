package collections;

import java.util.*;

//Колекция список
public class CollectionList {

    static void ex() {
        List<Object> arrayList = new ArrayList();
        List linkedList = new LinkedList();

        List<Object> objects = new ArrayList<>();
        objects.add("hello");
        objects.add(1);
        objects.add(new Object());
        System.out.println(objects);

        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(new Object());
        arrayList.add(null);
        System.out.println("has null and add new null = " + arrayList.add(null));
        //addAll добавляет 2 коллекцию к 1й (совмещая их), а add - добавляет 2ю колекцию как следующий элемент к 1й коллекции
        arrayList.addAll(List.of(1,2,3,4,5,6,7,7,7));

        System.out.println(arrayList);
        System.out.println("count elements of array list = " + arrayList.stream().count());

        linkedList.add(777);
        linkedList.add(new Object());
        linkedList.add(null);
        linkedList.addAll(arrayList);

        System.out.println("Список до : " + linkedList);
        System.out.println(linkedList.get(1));
        linkedList.remove(1);
        System.out.println(linkedList.get(1));
        System.out.println("Список после : " + linkedList);

        Collections.sort(linkedList);

        System.out.println(linkedList);

        class Hello { //inner class
            String hello;
            void sayHello(String hello) {
                this.hello = hello;
            }
            void printHello() {
                System.out.println(this.hello);
            }
        }

        Hello hello = new Hello();
        hello.sayHello("HELLO");
        hello.printHello();
    }

    static void ex_2() {
        List list = new ArrayList();
        list.addAll(List.of(7,2,3,4,1));
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        ex();
        ex_2();
    }
}
