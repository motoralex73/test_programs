package ibs;

import java.util.*;

public class FriendlySobes {

    public static class Pair {
        public int key = 0;
        public int value = 0;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(List.of(1, 2, 3, 4, 4, 5, 6, 7));
        List<Integer> l2 = new ArrayList<>(List.of(3, 4, 5, 6, 7));
        l1.addAll(l2);

        //1
        Map<Integer, Integer> map = new HashMap<>();
        Pair max = new Pair();
        int temp = 0;
        for (Integer i : l1) {
            if (map.containsKey(i)) {
                temp = map.get(i) + 1;
                map.put(i, temp);
            }
            else map.put(i,1);
            if (temp > max.value) {
                max.key = i;
                max.value = temp;
            }
        }
        System.out.println(map);
        System.out.println("1] " + max.key+" "+ max.value);

        //2
        Optional<Integer> m = map.values().stream().max(Integer::compareTo);
        for (var set : map.entrySet()) {
            if (m.equals(Optional.of(set.getValue()))) {
                System.out.println("2] " + set.getKey() + " " + set.getValue());
            }
        }
    }
}
