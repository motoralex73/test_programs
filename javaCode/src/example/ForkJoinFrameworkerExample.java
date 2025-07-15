package example;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFrameworkerExample {

    static long numOfOperations = 1_000_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    static void printCountThread() {
        System.out.println("count thread = "+numOfThreads);
    }

    static class MyFork extends RecursiveTask<Long> {
        long from, to;
        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }
        @Override
        protected Long compute() {
            if ((to - from) <= numOfOperations/numOfThreads) {
                long j=0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            }
            else {
                long middle = (to + from) / 2;
                MyFork firstHalt = new MyFork(from, middle);
                firstHalt.fork();
                MyFork secondHalt = new MyFork(middle+1, to);
                long secondValue = secondHalt.compute();
                System.out.println(Thread.currentThread().getName());
                return firstHalt.join() + secondValue;
            }
        }
    }

    static Long calcOneThread(long from, long to) {
        long j=0;
        for (long i = from; i < to; i++) {
            j += i;
        }
        return j;
    }

    public static void main(String[] args) {
        printCountThread();
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        System.out.println(pool.invoke(new MyFork(0, numOfOperations)));
        //calcOneThread(0, numOfOperations);
        System.out.println(new Date());
    }
}
