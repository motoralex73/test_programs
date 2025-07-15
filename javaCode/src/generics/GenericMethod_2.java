package generics;

public class GenericMethod_2 {

    //обобщенный метод
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) if (x.equals(v)) return true;
        return false;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5};
        if (isIn(2, nums)) System.out.println("2 is have");
        if (!isIn(7, nums)) System.out.println("7 is not have");
        String[] strings = {"one", "two", "three", "four", "five"};
        if (isIn("four", strings)) System.out.println("four is have");

    }
}
