package example;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class ExecutorServiceExample {
    static volatile int count = 0;
    static volatile int countThread = 10000;
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);
        executorService.submit(new MyRunnable());
        System.out.println(executorService.submit(new MyCallable()).get());
        new Thread(new MyRunnable()).start();
        MyThread myThread = new MyThread();
        myThread.start();
        executorService.shutdownNow();
    }
    static void stopThread() throws InterruptedException {
        if (count==countThread) {System.out.println("count="+count);
            //Thread.currentThread().stop();
            sleep(1000); count=0;
        }
    }
    static class MyRunnable implements Runnable {
        @Override
        public synchronized void run() {
            while (true) {
                try {
                    lock.lock();
                    count++;
                    System.out.println("count="+count+" nameThread: "+Thread.currentThread().getName());
                    stopThread();
                    lock.unlock();
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
    static class MyThread extends Thread {
        public void run() {
            while(true) {
                lock.lock();
                count++;
                System.out.println("count="+count+" myThread:"+Thread.currentThread().getName());
                try {
                    stopThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
