package parallel;

import java.util.Date;
import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        System.out.println(new Date());
        Exchanger<String> exchanger = new Exchanger<>();
        new Mike(exchanger); //sender
        new Anket(exchanger); //receiver
    }
    static class Mike extends Thread {
       Exchanger<String> exchanger;
        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                exchanger.exchange("Hello, my name Mike");
                sleep(1000);
                exchanger.exchange("Im 20 years old");
                sleep(1000);
                System.out.println("Mike receive: "+exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Anket extends Thread {
        Exchanger<String> exchanger;
        public Anket(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));
                sleep(1000);
                System.out.println(exchanger.exchange(null));
                sleep(1000);
                exchanger.exchange("Hello Mike, see you later");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date());
        }
    }
}
