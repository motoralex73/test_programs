package util;

import java.util.Random;
import java.util.TimerTask;

public class UtilRandom {

    public static void main(String[] args) {
        Random random = new Random();
        int[] bell = new int[10];
        for (int i : bell) {
            bell[i] = random.nextInt(1,30);
            //System.out.println(bell[i]);
            for (int j=1; j<=bell[i]; j++) System.out.print("*");
            System.out.println();
        }
    }
}
