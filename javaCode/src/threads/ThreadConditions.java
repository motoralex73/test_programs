package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadConditions {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int account = 0;

    static class AccountPlus extends Thread {
        public void run() {
            lock.lock();
            account += 10;
            condition.signal();
            lock.unlock();
        }
    }

    static class AccountMinus extends Thread {
        public void run() {
            if (account < 10) {
                try {
                    lock.lock();
                    System.out.println("account = "+account);
                    condition.await();
                    System.out.println("account = "+account);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            account -= 10;
            System.out.println("account at the end = " + account);
        }
    }

    public static void main(String[] args) {
        new AccountMinus().start();
        new AccountPlus().start();
    }





}
