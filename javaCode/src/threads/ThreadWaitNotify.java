package threads;

public class ThreadWaitNotify {

    static class Q {
        int n;
        boolean valueSet = false;

        synchronized int get() {
            while (!valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Перехвачено исключение InterruptedException");
                }
            }
            System.out.println("Получено: " + n);
            valueSet = false;
            notify();
            return n;
        }

        synchronized void put(int n) {
            while (valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Перехвачено исключение InterruptedException");
                }

            }
            this.n = n;
            valueSet = true;
            System.out.println("Отправлено: " + n);
            notify();
        }
    }

    static class Produser implements Runnable {
        Q q;
        Thread t;
        Produser(Q q) {
            this.q = q;
            t = new Thread(this, "Производитель");
        }
        public void run() {
            int i = 0;
            while (true) q.put(i++);
        }
    }

    static class Consumer implements Runnable {
        Q q;
        Thread t;
        Consumer(Q q) {
            this.q = q;
            t = new Thread(this,"Потребитель");
        }
        public void run() {
            while (true) q.get();
        }
    }

    public static void main(String[] args) {
        Q q = new Q();
        Produser p = new Produser(q);
        Consumer c = new Consumer(q);
        p.t.start();
        c.t.start();
    }
}
