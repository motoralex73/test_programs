package strings;

public class StringAllExample {

    public static void main(String[] args) {

        String string = new String();
        System.out.println("string length = " + string.length());

        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("buffer length = " + stringBuffer.length() + " capacity = " + stringBuffer.capacity());

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("builder length = " + stringBuilder.length() + " capacity = " + stringBuilder.capacity());
    }
}
