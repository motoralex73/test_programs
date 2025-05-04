package example;

public class AddString {

    public static void main(String[] args) {

        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2);

        Integer i3 = new Integer(100);
        Integer i4 = new Integer(100);
        System.out.println(i3 == i4);

        Integer i5 = 300;
        Integer i6 = 300;
        System.out.println(i5 == i6);
        int xz = 123;
        //System.out.println(String.format("0x%x", System.identityHashCode(xz)));
        System.out.println(Integer.toHexString(System.identityHashCode(xz)));

        String str1 = "Hello";
        String str0 = "lo";
        String str2 = "Hel"+str0;
        System.out.println(str2.equals(str1));


        Integer i11 = new Integer(123);
        Integer i21 = new Integer(123);

        System.out.println("Сравнение по equals (по содержимому) = " + (i11.equals(i21)));
        System.out.println("Сравнение по hashCode (по хеш-коду, адресу памяти по ссылкам) = " + (i11 == i21));
        String str11 = "hello";
        String str21 = "hello";
        String str31 = new String("hello");
        //это связано с мутабельностью класса String (объекты нельзя изменять, создаются копии в пуле), смотрит String Pool (в нем создаются строки)
        System.out.println("Сравнение по == для string по ссылкам = " + (str11 == str21));
        //Объект созданный при помощи new создается и попадает в HeapMemory
        System.out.println("Сравнение по == для string по ссылкам один из объектов создан при помощи new = " + (str11 == str31));

    }

}
