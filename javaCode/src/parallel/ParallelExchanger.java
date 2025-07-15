package parallel;

import java.util.concurrent.Exchanger;

public class ParallelExchanger {

    static class MakeString implements Runnable {
        Exchanger<String> ex;
        String str;

        public MakeString(Exchanger<String> ex) {
            this.ex = ex;
            str = new String();
        }

        public void run() {
            char ch = 'A';
            for (int i=0;i<3;i++) {
                for (int j=0;j<5;j++) str += ch++;
                try {
                    str = ex.exchange(str);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    static class UseString implements Runnable {
        Exchanger<String> ex;
        String str;

        public UseString(Exchanger<String> ex) {
            this.ex = ex;
        }

        public void run() {
            for (int i=0;i<3;i++) {
                try {
                    str = ex.exchange(new String());
                    System.out.println("Получено: " + str);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        var ex = new Exchanger<String>();
        new Thread(new UseString(ex)).start();
        new Thread(new MakeString(ex)).start();
    }
}
