package collections;

import java.util.*;

//Множество - коллекция, которая НЕ может содержать повторных элементов
public class CollectionSet {

    public static void main(String[] args) {

        Set hashSet = new HashSet();
        Set treeSet = new TreeSet();
        Set linkedSet = new LinkedHashSet();

        hashSet.add(new Object());
        hashSet.add(123);
        hashSet.add("new hash set");
        hashSet.add(123);
        hashSet.add(null);
        hashSet.add(null);
        //System.out.println("contains = " + hashSet.remove(123));
        if (!hashSet.isEmpty())
        System.out.println("count hashSet = "+hashSet.stream().count());
        System.out.println("hash set = " + hashSet);

        treeSet.add(777);
        treeSet.add(345);
        treeSet.add(555);
        treeSet.add(555);
        System.out.println("has 555 and add 555 = " + treeSet.add(555));
        System.out.println("tree set = " + treeSet);
        System.out.println(treeSet.removeAll(hashSet));

        linkedSet.add(1);
        linkedSet.add("her");
        linkedSet.add(1);
        System.out.println("linked set = " + linkedSet);

        List<Integer> list = List.of(1,2,3,4,5,6,7);
        System.out.println(list);
        Set<Integer> set = Set.of(1, 2, 3, 4);
        System.out.println(set);
    }
}
