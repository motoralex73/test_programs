package book_example.chapter_1;

//Сложение двух крупных чисел типа int/long и переполнение операции
public class Task_26 {

    public static void main(String[] args) {

        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        long z = Math.addExact(x,y);
        //System.out.println("Переполняем long : " + z);
    }
}
