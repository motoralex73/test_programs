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

import java.util.HashMap;
import java.util.Map;

public class N5_LongestPalindromicString {

    static boolean isPalindrome(String s) {

        for (int i = 0, j = s.length()-1; i < s.length()/2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome2(String s) {
        for (int i = s.length()/2-2, j = s.length()/2-1; i > 0; i--, j++) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bxab1babbcasasdFuckerrekcuF123";
        boolean isHave = false;
        String goodString;
        Map<Integer, String> map = new HashMap<>();
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j > 0; j--) {
                try {
                    goodString = s.substring(i, j);
                    isHave = isPalindrome(goodString);
                    if (isHave && goodString.length() > 1) {
                        //System.out.println("HAPPY NICE PALINDROME = " + goodString);
                        map.put(goodString.length(), goodString);
                    }
                }
                catch (Exception e) {
                    goodString = "NO";
                }
            }
        }
        System.out.println(map);

        int temp = 0;
        int maxValue = 0;
        for (var m : map.entrySet()) {
            if (m.getKey() > temp) maxValue = m.getKey();
            else maxValue = temp;
            temp = m.getKey();
        }
        System.out.println("Long substring = " + map.get(maxValue));
    }
}
