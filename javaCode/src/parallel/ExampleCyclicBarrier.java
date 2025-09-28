package parallel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ExampleCyclicBarrier {

    static class MyCyclicBarrier extends Thread {

        CyclicBarrier cyclicBarrier;
        String threadName;

        public MyCyclicBarrier(String threadName, CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
            this.threadName = threadName;
        }
        @Override
        public void run() {
            System.out.println("start thread = " + threadName);
            try {
                Thread.sleep(1000);
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class MyBarrier extends Thread {
        @Override
        public void run() {
            System.out.println("Барьер достигнут");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new MyBarrier());
        System.out.println("Начало");
        new MyCyclicBarrier("1",cyclicBarrier).start();
        new MyCyclicBarrier("2",cyclicBarrier).start();
        new MyCyclicBarrier("3",cyclicBarrier).start();
        new MyCyclicBarrier("4",cyclicBarrier).start();
        new MyCyclicBarrier("5",cyclicBarrier).start();
        new MyCyclicBarrier("6",cyclicBarrier).start();
        System.out.println("Конец");
    }
}
