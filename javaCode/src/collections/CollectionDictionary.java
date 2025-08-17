package collections;

import java.util.*;

public class CollectionDictionary {

    public static void main(String[] args) {

        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.addLast("1");
        linkedList.addLast(2);
        for (Object i : linkedList) System.out.println(i);
    }
}
