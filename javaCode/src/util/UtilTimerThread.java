package util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class UtilTimerThread {

    static class MyTimerClass extends TimerTask {
        int count = 0;
        public void run() {
            Date d = new Date();
            System.out.println("Start timer-thread, count = " + ++count + " timer min = " + d.getMinutes() + " sec = " + d.getSeconds());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTimerClass myTimerClass = new MyTimerClass();
        Timer t = new Timer();
        t.schedule(myTimerClass,1000,500);
        Thread.sleep(1000);
    }
}
