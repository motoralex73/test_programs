package collections;

import java.util.*;

public class CollectionDictionary {


    public static void main(String[] args) {

        LinkedList iterable = new LinkedList();
        iterable.addLast("1");
        iterable.addLast(2);
        for (Object i : iterable) System.out.println(i);


    }
}
