package book_example.chapter_2;

import java.util.Objects;

//Проверка подынтервала в интервале от 0 до длины
public class Task_45 {

    //1
    public static class FunctionClass {
        private final int n;

        public FunctionClass(int n) {
            if (n < 0 || n >= 101) throw new IndexOutOfBoundsException("n < 0 || n >= 101");
            this.n = n;
        }
        public int yMinusX(int x, int y) {
            if (x < 0 || x > y || y >= n) throw new IndexOutOfBoundsException("x < 0 || x > y || y >= n");
            return y - x;
        }
    }

    //2
    public static class FunctionClass_2 {
        private final int n;

        public FunctionClass_2(int n) {
            this.n = Objects.checkIndex(n,101);
        }
        public int yMinusX(int x, int y) {
            Objects.checkFromToIndex(x,y,n);
            return y - x;
        }
    }

    public static void main(String[] args) {
        //1
        FunctionClass functionClass = new FunctionClass(100);
        System.out.println(functionClass.yMinusX(12,15));
        //2
        FunctionClass_2 functionClass_2 = new FunctionClass_2(100);
        System.out.println(functionClass_2.yMinusX(12,15));
    }
}
