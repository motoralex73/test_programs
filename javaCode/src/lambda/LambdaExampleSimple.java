package lambda;

public class LambdaExampleSimple {

    interface LambdaInterface {
        double getDouble();
    }

    interface NumberClass {
        boolean test(int n);
    }

    interface NumberClass_2 {
        boolean test(int a, int b);
    }

    public static void main(String[] args) {
        //1
        LambdaInterface li = () -> 123.45;
        System.out.println(li.getDouble());
        //2
        NumberClass isEvent = (n) -> (n % 2) == 0;
        if (isEvent.test(10)) System.out.println("10 -> Четное число");
        if (!isEvent.test(9)) System.out.println("9 -> Нечетное число");

        NumberClass isNoNeg = (n) -> (n >= 0);
        if (isNoNeg.test(1)) System.out.println("1 -> Положительное число");
        if (!isNoNeg.test(-1)) System.out.println("-1 -> Отрицательное число");
        //3
        NumberClass_2 isFactor = (a,b) -> (a % b) == 0;
        if (isFactor.test(10,5)) System.out.println("5 является множителем 10");
        if (!isFactor.test(10,3)) System.out.println("3 не является множителем 10");

        NumberClass_2 tt = (int a, int b) -> (a % b) == 0;



    }
}
