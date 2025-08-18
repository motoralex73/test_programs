package example;

public class StaticExample {

    static class PP {
        static int p; //static field
        PP() {
            p = 1000;
            System.out.println("constructor PP p = " + p);
        }
        static  {
            p++;
            System.out.println("static p: " + p);
        }
    }

    public static void main(String[] args) {
        PP pp = new PP();
        pp.p = 111;
        PP.p = 222;
        System.out.println("pp.p = " + pp.p + ", PP.p = " + PP.p);
    }
}
