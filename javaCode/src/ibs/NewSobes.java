package ibs;

import java.util.*;

public class NewSobes {

    static Integer returnDigit(List<Integer> a1, List<Integer> a2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : a1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        for (Integer i : a2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());

        var pp = list.parallelStream()
        Integer d = Collections.max(list);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), d)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
           ArrayList<Integer> s1 = new ArrayList<>();
           s1.addAll(List.of(1,2,3,4,4,5));
           ArrayList<Integer> s2 = new ArrayList<>();
           s2.addAll(List.of(2,3,4,5,6));

        System.out.println(returnDigit(s1, s2));

    }
}

