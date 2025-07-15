package lambda;

//Блочные лямбда-выражения
public class LambdaExampleBlock {

    interface  FactInterface {
        int fact(int n);
    }

    public static void main(String[] args) {
        FactInterface fa = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) result *= i;
            return result;
        };

        System.out.println("Factorial = " + fa.fact(3));

    }
}
