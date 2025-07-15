package generics;

public class GenericMassive {

    //ограничение типа T
    static class StatsMassive<T extends Number> {
        T[] nums;

        public StatsMassive(T[] nums) {
            this.nums = nums;
        }
        double average() {
            double sum = 0.0;
            for (T num : nums) sum += num.doubleValue();
            return sum;
        }
    }

    public static void main(String[] args) {
        Integer[] massive = {1,2,3,4,5,6,7};
        var x = new StatsMassive<>(massive);
        double v = x.average();
        System.out.println(v);
    }
}
