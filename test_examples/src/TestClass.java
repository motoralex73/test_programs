public class TestClass {

    static void inc(Integer i) {i++; System.out.println(i);}
    static void incString(String i) { i = i+"2"; System.out.println(i);}

    public static void main(String[] args) {
        //1
        Integer i = Integer.valueOf(1);
        inc(i);
        System.out.println(i);
        //2
        String s = "1";
        incString(s);
        System.out.println(s);
        //3
        Integer i1 = Integer.valueOf(712);
        Integer i2 = Integer.valueOf(712);
        boolean x = false;
        if (i1.intValue() == i2.intValue()) x = true;
        System.out.println(x +" "+ i1 +" "+ i2);
        System.out.println(i1 == i2);
    }
}
