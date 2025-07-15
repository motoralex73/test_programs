package collections;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class CollectionVector {
    public static void main(String[] args) {
        Integer[] m = {1,2,3,4,5,6,7};
        Vector<Integer> vector = new Vector<>(List.of(m));
        vector.addElement(123);
        System.out.println(vector);
        System.out.println(vector.get(5));
    }
}
