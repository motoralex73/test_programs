package leetcode;

/*
7. Reverse Integer
* Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value
* to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

* */

public class N7_ReversInteger {

    public static void main(String[] args) {
        int digit = -23423400;
        boolean haveMinus = false;

        if (digit < 0) {
            digit = Math.abs(digit);
            haveMinus = true;
        }

        String s = String.valueOf(digit);
        StringBuilder sRevers = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--) {
            sRevers.append(s.charAt(i));
        }

        System.out.println(sRevers);
        digit = Integer.parseInt(String.valueOf(sRevers));

        if (haveMinus) {
            digit *= -1;
        }
        System.out.println(digit);
    }
}
