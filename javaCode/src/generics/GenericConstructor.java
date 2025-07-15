package generics;

public class GenericConstructor {

    public static class GenConstructor {
        private double val;

        public <T extends Number> GenConstructor(T val) {
            this.val = val.doubleValue();
        }
        public void showVal() {
            System.out.println("val = " + val);
        }
    }

        public static void main(String[] args) {
            new GenConstructor(123).showVal();
            new GenConstructor(125.0).showVal();
        }
}
