package collections;

import java.util.*;

public class CollectionMap {

    public static void main(String[] args) {
        Map hashMap = new HashMap();
        Map linkedMap = new LinkedHashMap();
        Map treeMap = new TreeMap();

        Map<String, String> map = Map.of("1","one", "2", "two");
        System.out.println(map.get("1"));
        Map<String, String> map2 = Map.ofEntries(
                Map.entry("key3", "value3"),
                Map.entry("key1", "value1")
        );

        hashMap.putAll(map);
        hashMap.putAll(map2);
        System.out.println("hashMap : " + hashMap);

        linkedMap.putAll(map);
        linkedMap.putAll(map2);
        System.out.println("linkedMap : " + linkedMap);

        treeMap.putAll(map);
        treeMap.putAll(map2);
        System.out.println("treeMap : " + treeMap);

        Map map3 = new HashMap();
        map3.putAll(hashMap);
        map3.putAll(linkedMap);
        map3.putAll(treeMap);
        System.out.println("map3 : " + map3);

        //итерирование по map
        Set<Map.Entry<String, String>> set = map3.entrySet();
        for (Map.Entry<String, String> me : set) {
            System.out.println("key = " + me.getKey());
            System.out.println("value = " + me.getValue());
        }


    }
}
