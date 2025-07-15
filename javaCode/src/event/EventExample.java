package event;

import java.awt.*;

public class EventExample {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setTitle("Hello world");
        f.setLocation(100,100);
        f.setSize(1000,1000);
        f.show();
        System.out.println(f.getWidth());
        System.exit(111);
    }
}
