package parallel;

import java.util.Arrays;
import java.util.concurrent.Phaser;

public class ParallelPhaser {

    static class MyThread implements Runnable {
        Phaser phaser;
        String name;

        public MyThread(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            this.phaser.register();
        }

        public void run() {
            System.out.println("Поток " + name + " начал первую стадию");
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Поток " + name + " начал вторую стадию");
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Поток " + name + " начал третью стадию");
            phaser.arriveAndAwaitAdvance();
        }
    }

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhase;
        System.out.println("Начало");

        new Thread(new MyThread(phaser, "A")).start();
        new Thread(new MyThread(phaser, "B")).start();
        new Thread(new MyThread(phaser, "C")).start();

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Стадия " + curPhase + " завершена");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Стадия " + curPhase + " завершена");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Стадия " + curPhase + " завершена");

        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) System.out.println("Объект Phaser закончил работу");
    }
}
