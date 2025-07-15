package parallel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ParallelCyclicBarrier {
    static class MyThread implements Runnable {

        CyclicBarrier cb;
        String name;

        public MyThread(CyclicBarrier cb, String name) {
            this.cb = cb;
            this.name = name;
        }

        public void run() {
            System.out.println(name);
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                System.out.println(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class BarAction implements Runnable {
        public void run() {
            System.out.println("Барьер достигнут");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        System.out.println("Начало");
        new Thread(new MyThread(cb,"A")).start();
        new Thread(new MyThread(cb,"B")).start();
        new Thread(new MyThread(cb,"C")).start();
    }
}
