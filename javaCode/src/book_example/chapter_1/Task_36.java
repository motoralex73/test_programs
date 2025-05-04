package book_example.chapter_1;

//Следующее значение с плавающей точкой
public class Task_36 {
    public static void main(String[] args) {

        float f = 0.1f;
        float nextDownF = Math.nextDown(f);
        float nextUpF = Math.nextUp(f);
        System.out.println(f + ") nextDownF = " + nextDownF + " nextUpF = " + nextUpF);

        double d = 0.1d;
        double nextDownD = Math.nextDown(d);
        double nextUpD = Math.nextUp(d);
        System.out.println(d + ") nextDownD = " + nextDownD + " nextUpD = " + nextUpD);
    }
}
