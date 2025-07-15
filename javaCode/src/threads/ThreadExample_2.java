package threads;

public class ThreadExample_2 {

    volatile static int count = 0;
    static class ThreadImplRunnable implements Runnable {
        Thread t;
        String name;
        ThreadImplRunnable(String name) {
            this.name = name;
            t = new Thread(this,name);
            System.out.println("Create new thread name = " + name);
        }
        @Override
        public void run() {
            while (true) {
                System.out.println("work thread impl runnable count = " + ++count + " name thread = " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadImplRunnable newThread = new ThreadImplRunnable("One");
        new ThreadImplRunnable("Two").t.start();
        newThread.t.start();
    }
}
