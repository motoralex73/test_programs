package generics;

public class GenericTwoType {

    static class TwoType<T,V> {
        T t;
        V v;

        public TwoType(T t, V v) {
            this.t = t;
            this.v = v;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        void showType() {
            System.out.println("show type t = " + t.getClass().getName() + ", v = " + v.getClass().getName());
        }
    }

    public static void main(String[] args) {
        TwoType<String, Integer> twoType = new TwoType<>("string",123);
        //var twoType = new TwoType<>("string",123);
        twoType.showType();
        System.out.println("t = " + twoType.getT() + ", v = " + twoType.getV());

    }
}
