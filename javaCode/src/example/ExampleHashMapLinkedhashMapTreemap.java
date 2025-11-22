package example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class ExampleHashMapLinkedhashMapTreemap {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(5,"A");
        hashMap.put(4,"B");
        hashMap.put(3,"C");
        hashMap.put(2,"D");
        hashMap.put(1,"E");

        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(5,"A");
        linkedHashMap.put(4,"B");
        linkedHashMap.put(3,"C");
        linkedHashMap.put(2,"D");
        linkedHashMap.put(1,"E");

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(3,"C");
        treeMap.put(1,"A");
        treeMap.put(5,"E");
        treeMap.put(2,"B");
        treeMap.put(4,"D");

        System.out.println("HashMap: " + hashMap);
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.println("TreeMap: " + treeMap);
    }
}
