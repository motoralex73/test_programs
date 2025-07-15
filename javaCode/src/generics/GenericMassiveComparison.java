package generics;

public class GenericMassiveComparison {

    static class NewCpmparison<T, V> {

        T[] t;
        V[] v;

        public NewCpmparison(T[] t, V[] v) {
            this.t = t;
            this.v = v;
        }

        boolean isComparison() {

            if (t.length == v.length) {
                //System.out.println("t.length == v.length");
                for (int i = 0; i < t.length; i++) {
                    var d1 = ((Number)t[i]).doubleValue();
                    var d2 = ((Number)v[i]).doubleValue();
                    //System.out.println("t = " + d1 + ", v = " + d2);
                    if (d1 != d2) {return false;}
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

        Short[] d1 = {1,2,3,4,5,6,7};
        Float[] d2 = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f,7.0f};

        var comp = new NewCpmparison<>(d1,d2);
        System.out.println(comp.isComparison());
    }
}
