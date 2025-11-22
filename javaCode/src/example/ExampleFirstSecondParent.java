package example;

public class ExampleFirstSecondParent {

    static class FirstParent {
        public FirstParent() {
            System.out.println("FirstParent");
        }
    }
    static class SecondParent extends FirstParent {
        public SecondParent() {
            System.out.println("SecondParent");
        }
    }
    static class ThirdParent extends SecondParent {
        public ThirdParent() {
            System.out.println("ThirdParent");
        }
    }

    public static void main(String[] args) {
        new ThirdParent();
    }
}
