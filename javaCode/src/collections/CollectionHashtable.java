package collections;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class CollectionHashtable {
    public static void main(String[] args) {
        Hashtable<String, Integer> tel = new Hashtable<>();
        tel.put("Alex", 3226);
        tel.put("Sergey", 2690);

        //1 enumeration
        Enumeration<String> en = tel.keys();
        String s;
        while (en.hasMoreElements()) {
            s = en.nextElement();
            System.out.println(s + " : " + tel.get(s));
        }
        //2 iterator
        Iterator<String> it = tel.keySet().iterator();
        while (it.hasNext()) {
            s = it.next();
            System.out.println(s + " : " + tel.get(s));
        }
    }
}
