package collections;

import java.util.*;

public class CollectionManyMethod {

    public static void main(String[] args) {
        List<String> ns = new LinkedList<>();
        ns.add("hello");
        ns.add("goodbye");
        Collections.sort(ns);
        System.out.println(ns);
    }
}
