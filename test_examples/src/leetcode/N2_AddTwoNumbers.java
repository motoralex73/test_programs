package leetcode;
/*
* 2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers.
* The digits are stored in reverse order, and each of their nodes contains a single digit.
* Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
* Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*
* Задача:
Даны два непустых связных списка (linked lists), которые представляют два неотрицательных целых числа.
* Цифры в них хранятся в обратном порядке, и каждый узел содержит одну цифру.
* Необходимо сложить эти два числа и вернуть их сумму в виде связного списка.
*
*  */

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.pow;

public class N2_AddTwoNumbers {

    static public long returnDigit(LinkedList<Integer> list) {
        long result = 0;

        for (int i = 0; i < list.size(); i++) {
            result += (long) (list.get(i) * pow(10, i));
        }

        return result;
    }

    static public LinkedList<Integer> returnList(long n) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("sum = " + n);
        String s = String.valueOf(n);
        System.out.println("string = " + s);
        for (int i = 0; i < s.length(); i++) {
            Integer num = Integer.valueOf(s.substring(i, i + 1));
            list.addFirst(num);
        }
        return list;
    }

    public static void main(String[] args) {
        var l1 = new LinkedList<>(List.of(2,4,3,1,3));
        var l2 = new LinkedList<>(List.of(5,6,4));

        System.out.println(returnDigit(l1) + " " + returnDigit(l2));

        long sum = returnDigit(l1) + returnDigit(l2);

        System.out.println(returnList(sum));
    }
}
