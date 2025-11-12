package example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleWithThreadKata {

    static int counter = 0;
    static final int countCycle = 100;
    static final Lock lock = new ReentrantLock();
    static boolean canIncrement = true;
    static boolean canDecrement = false;
    static boolean canPrint = false;

    public static class ThreadPlus implements Runnable {
        public void run() {
            for (int i = 0; i < countCycle; i++) {
                synchronized (lock) {
                    while (!canIncrement) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Thread was interrupted: " + e.getMessage());
                        }
                    }
                    counter+=2;
                    System.out.println("Incremented: counter = " + counter);
                    canIncrement = false;
                    canDecrement = true;
                    canPrint = false;
                    lock.notifyAll();
                }
            }
        }
    }

    public static class ThreadMinus implements Runnable {
        public void run() {
            for (int i = 0; i < countCycle; i++) {
                synchronized (lock) {
                    while (!canDecrement) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Thread was interrupted: " + e.getMessage());
                        }
                    }
                    counter--;
                    System.out.println("Decremented: counter = " + counter);
                    canIncrement = false;
                    canDecrement = false;
                    canPrint = true;
                    lock.notifyAll();
                }
            }
        }
    }

    public static class ThreadPrint implements Runnable {
        public void run() {
            for (int i = 0; i < countCycle; i++) {
                synchronized (lock) {
                    while (!canPrint) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Thread was interrupted: " + e.getMessage());
                        }
                    }
                    System.out.println("Printed: counter = " + counter);
                    canIncrement = true;
                    canDecrement = false;
                    canPrint = false;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        canIncrement = true; // Начинаем с инкремента

        Thread t1 = new Thread(new ThreadPlus());
        Thread t2 = new Thread(new ThreadMinus());
        Thread t3 = new Thread(new ThreadPrint());

        System.out.println("----- Start counter = " + counter);
        Thread.sleep(1000);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("----- Final counter = " + counter);
    }
}
