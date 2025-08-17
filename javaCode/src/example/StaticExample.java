package example;

public class StaticExample {

    static class PP {
        static int p; //static field
        PP() { p = 1000;}
        void countPlus() {
            p++;
        }
    }

    public static void main(String[] args) {
        PP pp = new PP();
        System.out.println(PP.p);
        pp.p = 111;
        PP.p = 222;
        pp.countPlus();
        System.out.println("pp.p = " + pp.p + ", PP.p = " + PP.p);
    }
}
