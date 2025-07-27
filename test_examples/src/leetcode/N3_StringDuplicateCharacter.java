package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
3. Longest Substring Without Repeating Characters
* Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
* */

public class N3_StringDuplicateCharacter {
    public static void main(String[] args) {
        String s = "leetcode";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c) + 1);
            }
            else map.put(c,1);
        }
        System.out.println(map);
    }
}
