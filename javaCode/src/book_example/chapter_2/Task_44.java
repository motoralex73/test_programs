package book_example.chapter_2;

import java.util.Objects;

//Проверка индекса в интервале от 0 до длины
public class Task_44 {

    public static class Function_1 {
        private final int x;
        private static final int X_UPPER_BOUND = 11;
        private static final int Y_UPPER_BOUND = 16;

        public Function_1(int x) {
            if (x < 0 || x >= X_UPPER_BOUND) throw new IndexOutOfBoundsException("...");
            this.x = x;
        }
        public int xMinusY(int y) {
            if (y < 0 || y >= x) throw new IndexOutOfBoundsException("....");
            return x - y;
        }
        public int oneMinusY(int y) {
            if (y < 0 || y >= Y_UPPER_BOUND) throw new IndexOutOfBoundsException(".....");
            return 1 - y;
        }
    }

    public static class Function_2 {
        private final int x;
        private static final int X_UPPER_BOUND = 11;
        private static final int Y_UPPER_BOUND = 16;

        public Function_2(int x) {
            this.x = Objects.checkIndex(x, X_UPPER_BOUND);
        }
        public int xMinusY(int y) {
            Objects.checkIndex(y, x);
            return x - y;
        }
        public int oneMinusY(int y) {
            Objects.checkIndex(y, Y_UPPER_BOUND);
            return 1 - y;
        }
    }

    public static void main(String[] args) {

        Function_2 function_2 = new Function_2(5);
        System.out.println(function_2.oneMinusY(10));
    }
}
