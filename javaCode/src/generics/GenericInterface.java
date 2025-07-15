package generics;

public class GenericInterface {

    interface MinMax<T extends Comparable<T>> {
        T min();
        T max();
    }

    static class GenericClass<T extends Comparable<T>> implements MinMax<T> {
        T[] vals;
        public GenericClass(T[] vals) {
            this.vals = vals;
        }
        public T min() {
            T v = vals[0];
            for (int i = 1; i < vals.length; i++)
                if (vals[i].compareTo(v) < 0) v = vals[i];
            return v;
        }
        public T max() {
            T v = vals[0];
            for (int i = 1; i < vals.length; i++)
                if (vals[i].compareTo(v) > 0) v = vals[i];
            return v;
        }
    }

    public static void main(String[] args) {

        Integer[] integers = {1,2,3,4,5,6,7};
        Character[] characterps = {'a', 'b', 'c'};

        GenericClass<Integer> iob = new GenericClass<>(integers);
        System.out.println(iob.max());
        GenericClass<Character> cob = new GenericClass<>(characterps);
        System.out.println(cob.max());
    }
}


