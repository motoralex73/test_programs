package strings;

public class StringExample {

    public static void main(String[] args) {
        char[] c = {'J','a','v','a'};
        String s = new String(c);
        System.out.println(s);
        String hello = "thisHelloJava";
        //String s1 = new String(hello.getChars(4,9));
        String s1 = "            Hello    World    ".trim();
        System.out.println(s1);

    }



}
