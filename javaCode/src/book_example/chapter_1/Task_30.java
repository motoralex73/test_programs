package book_example.chapter_1;

//Вычисление частного и остатка от деления беззнаковых значений
public class Task_30 {
    public static void main(String[] args) {
        int intMin = Integer.MIN_VALUE;
        int intMax = Integer.MAX_VALUE;
        int a = intMax / intMin;
        int b = intMax % intMin;
        System.out.println("intMin = " + intMin + " intMax = " + intMax);
        System.out.println(a+" "+b);

        //беззнаковое частное
        int aa = Integer.divideUnsigned(intMin, intMax);
        int bb = Integer.divideUnsigned(intMax, intMin);
        System.out.println(aa+" "+bb);
        //беззнаковый остаток
        int cc = Integer.remainderUnsigned(intMax, intMax);
        int dd = Integer.remainderUnsigned(intMax, intMin);
        System.out.println(cc+" "+dd);
    }
}
