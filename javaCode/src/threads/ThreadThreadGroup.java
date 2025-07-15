package threads;

public class ThreadThreadGroup {

    static class NewThread extends Thread {
        boolean suspendFlag;
        NewThread(String threadName, ThreadGroup threadGroup) {
            super(threadGroup, threadName);
            suspendFlag = false;
        }

        public void run() {
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println(getName() + ": " + i);
                    Thread.sleep(10000);
                    synchronized (this) {
                        while (suspendFlag) wait();
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Исключение в " + getName());
            }
        }
        synchronized void mysuspend() {
            suspendFlag = true;
        }
        synchronized void myresume() {
            suspendFlag = false;
            notify();
        }
    }

    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        NewThread ob1 = new NewThread("One", groupA);
        NewThread ob2 = new NewThread("Two", groupA);
        NewThread ob3 = new NewThread("Three", groupB);
        NewThread ob4 = new NewThread("Four", groupB);

        ob1.start();
        ob2.start();
        ob3.start();
        ob4.start();

        System.out.println("\nВыход из list():");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Приостановка Group A");
        Thread[] tga = new Thread[groupA.activeCount()];
        groupA.enumerate(tga);
        for (Thread thread : tga) {
            ((NewThread) thread).myresume();
        }
        try {
            System.out.println("Ожидание завершения работы потоков.");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        } catch (Exception e) {
            System.out.println("Исключение в главном потоке");
        }
        System.out.println("Главный поток завершает работу.");
    }
}
