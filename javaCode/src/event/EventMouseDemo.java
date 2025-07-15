package event;

import java.awt.*;
import java.awt.event.*;

public class EventMouseDemo extends Frame implements MouseListener, MouseMotionListener, KeyListener {

    String msgKey = "";
    public void keyTyped(KeyEvent e) {
        //msgKey += e.getKeyChar();

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        //msgKey = "Key down";

        int key = e.getKeyCode();
        System.out.println("KEY TYPE = " + key);
        switch (key) {
            case KeyEvent.VK_1 :
                msgKey = "<1>";
                System.out.println("!!!!!!!!!!!!!!!!!!!!");
                break;
            default:
                msgKey += e.getKeyChar();
                break;
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {
        //msgKey = "Key up";
        repaint();
    }



    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    String msg = "";
    int mouseX = 0, mouseY = 0;

    public EventMouseDemo() {
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    public void mouseClicked(MouseEvent e) {
        msg = msg + "--- click received";
        System.out.println(msg);
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button down";
        System.out.println(msg);
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button released";
        System.out.println(msg);
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse entered";
        System.out.println(msg);
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        mouseX = 50;
        mouseY = 50;
        msg = "Mouse exited";
        System.out.println(msg);
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Mouse at: x = " + e.getX() + ", y = " + e.getY();
        System.out.println(msg);
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
        msg = "Mouse moving: x = " + e.getX() + ", y = " + e.getY();
        System.out.println(msg);
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
        g.drawString(msgKey, 20, 100);
    }

    public static void main(String[] args) {
        EventMouseDemo a = new EventMouseDemo();
        a.setSize(new Dimension(300, 300));
        a.setTitle("Hello mouse window");
        a.setVisible(true);
    }
}
