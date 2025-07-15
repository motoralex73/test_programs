package parallel;

import java.util.concurrent.Semaphore;

public class ParallelSemaphore {

    class Shared {
        static int count = 0;
    }

    static class IncThread implements Runnable {
        String name;
        Semaphore sem;

        public IncThread(String name, Semaphore sem) {
            this.name = name;
            this.sem = sem;
        }

        public void run() {
            System.out.println("Запуск " + name);
            try {
                System.out.println(name + " ожидает разрешения");
                sem.acquire();
                System.out.println(name + " получил разрешение");
            } catch (Exception e) {
                System.out.println(e);
            }
            for (int i=0;i<5;i++) {
                Shared.count++;
                System.out.println(name + " : " + Shared.count);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(name + " освободил разрешение");
            sem.release();
        }
    }

    public static class DecThread implements Runnable {
        String name;
        Semaphore sem;

        public DecThread(String name, Semaphore sem) {
            this.name = name;
            this.sem = sem;
        }

        public void run() {
            System.out.println("Запуск " + name);
            try {
                System.out.println(name + " ожидает разрешения");
                sem.acquire();
                System.out.println(name + " получил разрешение");
            } catch (Exception e) {
                System.out.println(e);
            }
            for (int i=0;i<5;i++) {
                Shared.count--;
                System.out.println(name + " : " + Shared.count);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(name + " освободил разрешение");
            sem.release();
        }
    }

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new Thread(new IncThread("A", sem)).start();
        new Thread(new DecThread("B", sem)).start();
    }



}
