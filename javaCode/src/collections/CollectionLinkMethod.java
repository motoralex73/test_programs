package collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CollectionLinkMethod {

    static class CollectionClass {
        private int val;

        public CollectionClass(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    class SuperGood {
        static int compareMc(CollectionClass c1, CollectionClass c2) {
            return c1.getVal() - c2.getVal();
        }
    }

    public static void main(String[] args) {

        var list = new ArrayList<CollectionClass>();
        list.add(new CollectionClass(1));
        list.add(new CollectionClass(4));
        list.add(new CollectionClass(5));
        list.add(new CollectionClass(2));
        list.add(new CollectionClass(2));
        list.add(new CollectionClass(7));
        for (CollectionClass i : list) System.out.print(i.getVal() + " ");

        CollectionClass maxValue = Collections.max(list, SuperGood::compareMc);
        System.out.println("\nmax = " + maxValue.getVal());
    }


}
