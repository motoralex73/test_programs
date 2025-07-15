package lambda;

public class LambdaGeneric {

    interface NumberClass<T> {
        boolean test(T t);
    }

    interface NumberClass_2<T> {
        boolean test(T t1, T t2);
    }

    interface NumberClass_3<T, V> {
        boolean test(T t, V v);
    }
    public static void main(String[] args) {

        //1
        NumberClass<Integer> isEvent = (n) -> (n % 2) == 0;
        if (isEvent.test(10)) System.out.println("10 -> Четное число");
        if (!isEvent.test(9)) System.out.println("9 -> Нечетное число");

        NumberClass<Integer> isNoNeg = (n) -> (n >= 0);
        if (isNoNeg.test(1)) System.out.println("1 -> Положительное число");
        if (!isNoNeg.test(-1)) System.out.println("-1 -> Отрицательное число");
        //2
        NumberClass_2<Integer> isFactor = (a, b) -> (a % b) == 0;
        if (isFactor.test(10,5)) System.out.println("5 является множителем 10");
        if (!isFactor.test(10,3)) System.out.println("3 не является множителем 10");

        NumberClass_3<String, Integer> pair = (s, n) -> {
            System.out.println("Enter pair : name = " + s + ", age = " + n);
            return true;
        };
        pair.test("Alex", 38);
    }
}
