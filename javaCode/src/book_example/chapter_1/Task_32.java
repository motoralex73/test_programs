package book_example.chapter_1;

//Применение логического И/ИЛИ/исключающего ИЛИ к двум булевым выражениям (AND, OR, XOR)
public class Task_32 {
    public static void main(String[] args) {
        int s = 10;
        int m = 21;
        //если (s > m && m < 50) {} иначе {}
        if (Boolean.logicalAnd(s > m, m < 50)) {} else {}
        //если (s > m || m < 50) {} иначе {}
        if (Boolean.logicalOr(s > m, m < 50)) {} else {}
        //если (s > m ^ m < 50) {} иначе {}
        if (Boolean.logicalXor(s > m, m < 50)) {} else {}
    }
}
