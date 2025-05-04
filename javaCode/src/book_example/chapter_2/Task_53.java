package book_example.chapter_2;

//Клонирование объектов
public class Task_53 {

    public static class Point implements Cloneable{
        private double x;
        private double y;

        public Point() {
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point another) {
            this.x = another.x;
            this.y = another.y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public Point clonePoint() {
            Point point = new Point();
            System.out.println("clonePoint");
            point.setX(this.x);
            point.setY(this.y);
            return point;
        }

        @Override
        public Point clone() {
            try {
                System.out.println("clone");
                return (Point) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    public void main(String[] args) throws CloneNotSupportedException {
        Point point = new Point();
        Point clone = point.clone();
    }
}
