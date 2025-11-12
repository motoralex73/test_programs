package parallel;

import java.util.concurrent.CountDownLatch;

public class ParallelCountDownLatch {

    static class MyThread implements Runnable {

        CountDownLatch latch;
        public MyThread(CountDownLatch latch) {
            this.latch = latch;
        }
        public void run() {
            for (int i=0;i<5;i++) {
                System.out.println(i);
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        new Thread(new MyThread(countDownLatch)).start();
        countDownLatch.await();
        System.out.println("Конец");
    }
}
