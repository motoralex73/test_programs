package strings;

public class StringStringBuilder {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello string builder");
        stringBuilder.setCharAt(1,'I');
        stringBuilder.setLength(2);
        System.out.println(stringBuilder);

        char[] getter = new char[2];
        stringBuilder.getChars(0,2, getter,0);
        System.out.println(getter);

        stringBuilder.append("friend");
        stringBuilder.insert(2," my ");
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.reverse());
        System.out.println(stringBuilder.reverse().delete(2,5)+"!");
        stringBuilder.setLength(stringBuilder.length());
        System.out.println(stringBuilder.replace(0,2, "Hello my"));
        System.out.println(stringBuilder.substring(0,5));

    }
}
