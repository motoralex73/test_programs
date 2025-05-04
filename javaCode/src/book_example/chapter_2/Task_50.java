package book_example.chapter_2;

//Передача мутируемых объектов в немутируемый класс и возврат мутируемых объектов из него
public class Task_50 {

    public static class Radius {
        private int start;
        private int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }


    public static final class Point {
        private final double x;
        private final double y;
        private final Radius radius;

        public Point(double x, double y, Radius radius) {
            this.x = x;
            this.y = y;

            Radius clone = new Radius();
            clone.setStart(radius.getStart());
            clone.setEnd(radius.getEnd());

            this.radius = clone;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Radius getRadius() {
            return radius;
        }
    }

    public static void main(String[] args) {

        Radius radius = new Radius();
        radius.setStart(25);
        radius.setEnd(35);
        Point point = new Point(12.0,13.0,radius);
        System.out.println(point.getRadius().getStart());
    }
}
