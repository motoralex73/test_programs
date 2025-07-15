package strings;

public class StringAllExample {

    public static void main(String[] args) {

        String string = new String("hello");
        System.out.println("string length = " + string.length()+ " capacity = no");

        StringBuffer stringBuffer = new StringBuffer("hello");
        System.out.println("buffer length = " + stringBuffer.length() + " capacity = " + stringBuffer.capacity());

        StringBuilder stringBuilder = new StringBuilder("hello");
        System.out.println("builder length = " + stringBuilder.length() + " capacity = " + stringBuilder.capacity());
    }
}
