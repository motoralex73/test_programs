package leetcode;


/*
* 32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

* Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

* * Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

* Example 3:
Input: s = ""
Output: 0
* */

public class N32_LongestValidParentheses {

    public static void firstVariant(String s) {
        int len = s.length();
        int count = 0;
        for (int i=0;i<len;i++) {
            if ( (i+1)<len && s.charAt(i) == '(' && s.charAt(i+1) == ')' ) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void secondVariant(String s) {

//        int len = s.length()/2;
//        for (int i=len-1, j=len; i>=0; i--,j++) {
//            if (s.charAt(i) == '')
//        }

        int len = s.length();
        int result = 0;
        int countLeft = 0, countRight = 0;

        for (int i=0;i<len;i++) {
            if (s.charAt(i) == '(') countLeft++;
            else countRight++;
        }
        System.out.println("l = " + countLeft+", r = " + countRight);
        if (countLeft > countRight) result = countRight;
        else result = countLeft;
        System.out.println(result);
    }

    public static void main(String[] args) {

        String s = ")()(()()(((((())";
        secondVariant(s);
    }
}
