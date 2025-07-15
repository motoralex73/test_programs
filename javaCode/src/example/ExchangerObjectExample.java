package example;

import java.util.concurrent.Exchanger;

import static java.lang.Thread.sleep;

public class ExchangerObjectExample {

    public static void receiveMethod(Exchanger<ObjectToSend> exchanger) {
        new RecvObject(exchanger); //receiver
    }

    public static void main(String[] args) throws InterruptedException {
        Exchanger<ObjectToSend> exchanger = new Exchanger<>();
        new SendObject(exchanger); //sender
        System.out.println("waiting receive object...");
        System.out.println("this some process, please wait.");
        sleep(5000);
        receiveMethod(exchanger);
    }

    static class SendObject extends Thread {
        Exchanger<ObjectToSend> exchanger;
        public SendObject(Exchanger<ObjectToSend> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                ObjectToSend objectToSend = new ObjectToSend();
                objectToSend.setId(123);
                objectToSend.setName("First object");
                exchanger.exchange(objectToSend);
                System.out.println("first object was send.");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class RecvObject extends Thread {
        Exchanger<ObjectToSend> exchanger;
        public RecvObject(Exchanger<ObjectToSend> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                ObjectToSend objectToSend = exchanger.exchange(null);
                System.out.println("Receive object: "+objectToSend.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ObjectToSend {
        @Override
        public String toString() {
            return "Object: id=" + id + ", name=" + name;
        }
        private int id;
        private String name;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
