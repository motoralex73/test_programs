package threads;

public class ThreadExample_3 {

    static class CallMe {
        void call(String msg) {
            System.out.print("["+msg);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("]");
        }
    }
    static class Caller implements Runnable {
        String msg;
        Thread t;
        CallMe callMe;
        Caller(CallMe callMe, String msg) {
            this.callMe = callMe;
            this.msg = msg;
            t = new Thread(this);
        }
        @Override
        public void run() {
            synchronized (callMe) {
                callMe.call(msg);
            }
        }
    }

    public static void main(String[] args) {

        CallMe callMe = new CallMe();
        Caller c1 = new Caller(callMe,"Hello");
        Caller c2 = new Caller(callMe,"My");
        Caller c3 = new Caller(callMe,"Friend");

        c1.t.start();
        c2.t.start();
        c3.t.start();

        try {
            c1.t.join(); //ожидание завершения потока
            c2.t.join();
            c3.t.join();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
