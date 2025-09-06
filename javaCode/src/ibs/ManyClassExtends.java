package ibs;

public class ManyClassExtends {

    class B1 {
        int b1;
        public B1(int b1) {
            this.b1 = b1;
        }
        void methodB1() {}
    }

    class B {
        void methodB() {}
    }

    class C {
        void methodC() {}
    }

    class D {
        void methodD() {}
    }

    abstract class All extends B1 {

        public All(int b1) {
            super(b1);
        }

        abstract void method();

        B b = new B();
        C c = new C();
        D d = new D();

        public void getB() {
            this.b.methodB();
        }

        public void getC() {
            this.c.methodC();
        }

        public void getD() {
            this.d.methodD();
        }

    }
}
