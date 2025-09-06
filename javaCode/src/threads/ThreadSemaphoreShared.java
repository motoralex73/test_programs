package threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSemaphoreShared {

    class Shared {
        static Integer count;
    }

    static class IncrementThread implements Runnable {

        String name;
        Semaphore sem;

        public IncrementThread(String name, Semaphore sem) {
            this.name = name;
            this.sem = sem;
        }

        public void run() {
            while (true) {
                try {
                    System.out.println(name + " ожидает своей очереди");
                    Thread.sleep(1000);
                    sem.acquire();
                    Shared.count++;
                    System.out.println("increment count = " + Shared.count);
                    System.out.println(name);
                    sem.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class DecrementThread implements Runnable {

        String name;
        Semaphore sem;

        public DecrementThread(String name, Semaphore sem) {
            this.name = name;
            this.sem = sem;
        }

        public void run() {
            while (true) {
                try {
                    System.out.println(name + " ожидает своей очереди");
                    Thread.sleep(1000);
                    sem.acquire();
                    Shared.count--;
                    System.out.println("decrement count = " + Shared.count);
                    System.out.println(name);
                    sem.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);
        new Thread(new IncrementThread("AAA", semaphore)).start();
        new Thread(new DecrementThread("BBB", semaphore)).start();
    }
}
