package generics;

public class GenericLinkInMethodAndGenerics {


    interface MyInterface<T> {
        int func(T[] vals, T v);
    }

    static class MyArrayOptions {
        static <T> int countMatching(T[] vals, T v) {
            int count = 0;
            for (T val : vals) {
                if (val == v) count++;
            }
            return count;
        }
    }

    static <T> int myOp(MyInterface<T> f, T[] vals, T v) {
            return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1,2,3,4,5,6,7};
        String[] strings = {"One", "Two", "Three", "Two"};
        int count;
        count = myOp(MyArrayOptions::<Integer>countMatching, vals, 4);
        System.out.println("count 4 = " + count);
        count = myOp(MyArrayOptions::<String>countMatching, strings, "Two");
        System.out.println("count two = " + count);
    }
}
