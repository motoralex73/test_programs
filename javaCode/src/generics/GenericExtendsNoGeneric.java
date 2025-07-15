package generics;

public class GenericExtendsNoGeneric {

    static class NoGeneric {
        String name;

        public NoGeneric(String name) {
            this.name = name;
        }
        void showName() {
            System.out.println("My name is " + name);
        }
    }

    static class HasGeneric<T extends Number> extends NoGeneric {

        T t;
        public HasGeneric(T t, String name) {
            super(name);
            this.t = t;
        }
        void showFullInfo() {
            showName();
            System.out.println("age = " + t.doubleValue());
        }
        
    }

    public static void main(String[] args) {
        HasGeneric<Integer> g = new HasGeneric<>(38, "Alex");
        g.showFullInfo();
    }
}
