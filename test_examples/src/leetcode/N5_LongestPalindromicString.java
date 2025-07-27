package leetcode;

/*
5. Longest Palindromic Substring
* Given a string s, return the longest palindromic substring in s.
*Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
* */

public class N5_LongestPalindromicString {

    static boolean isPalindrome(String s) {

        for (int i = 0, j = s.length()-1; i < s.length()/2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bxab1babbc";
        boolean isHave = false;
        String goodString;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1 - i; j > 0; j--) {
                try {
                    goodString = s.substring(i, j);
                }
                catch (Exception e) {
                    goodString = "NO";
                }
                System.out.println(goodString);
                isHave = isPalindrome(goodString);
                if (isHave && goodString.length() > 1) {
                    System.out.println("HAPPY NICE PALINDROME = " + goodString);
                    return;
                }
            }
        }
        System.out.println("no palindrome");
    }
}
