package java_lang;

public class LangInteger {


    public static void main(String[] args) {
        int num = 1999;
        System.out.println(num + " в двоичной форме = " + Integer.toBinaryString(num));
        System.out.println(num + " в 8-ричной форме = " + Integer.toOctalString(num));
        System.out.println(num + " в 16-ричной форме = " + Integer.toHexString(num));
    }
}
