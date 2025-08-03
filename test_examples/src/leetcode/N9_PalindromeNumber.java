package leetcode;

/*
9. Palindrome Number
* Given an integer x, return true if x is a palindrome, and false otherwise.
Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

* */

public class N9_PalindromeNumber {
    public static void main(String[] args) {

        int d = 123321;
        String s = String.valueOf(d);
        for (int i=0, j=s.length()-1; i<s.length()/2;i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {System.out.println("dont palindrome"); return;}
        }
        System.out.println("Ok palindrome");
    }
}
