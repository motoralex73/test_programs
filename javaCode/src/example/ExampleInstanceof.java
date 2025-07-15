package example;

public class ExampleInstanceof {

    public static void main(String[] args) {
        //1
        Number i = 123;
        if (i instanceof Integer iObject) {
            System.out.println("Ok instanceof object = " + iObject);
        }
        //2
        if (i instanceof Integer) {
            Integer iObject = (Integer) i;
            System.out.println("Традиционная версия instanceof = " + iObject);
        }
        //3
        Object[] someObject = {
          new String("Alpha"),
          new String("Betta"),
          "Gamma",
          Integer.valueOf(111)
        };
        for (int j=0; (someObject[j] instanceof String str) && (j < someObject.length); j++) {
            System.out.println("Обработка строки = " + str);
        }

    }
}
