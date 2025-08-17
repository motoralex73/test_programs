package ibs;

import java.util.Optional;

public class NewSber {

    public static void main(String[] args) {

        Optional<Integer> h = Optional.of(123);
        boolean h1 = h.isEmpty();
        System.out.println(h1);
    }
}
