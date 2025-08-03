package leetcode;

/*
*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

* */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class N14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = new String[] {
                "fflower",
                "helloflow",
                "aaaflight"
        };
        Set<String> commonSubstrings = findCommonSubstrings(strings);
        Optional<String> stringOptional =  commonSubstrings.stream().max((s1, s2) -> Integer.compare(s1.length(),s2.length()));
        System.out.println("Common substrings: " + stringOptional.get());
    }

    private static Set<String> findCommonSubstrings(String[] strings) {
        if (strings == null || strings.length == 0) return new HashSet<>();

        // Start with the first string and get all its substrings
        Set<String> substrings = getAllSubstrings(strings[0]);

        for (int i = 1; i < strings.length; i++) {
            substrings.retainAll(getAllSubstrings(strings[i]));
        }
        return substrings;
    }

    private static Set<String> getAllSubstrings(String str) {
        Set<String> substrings = new HashSet<>();
        // Generate all possible substrings
        for (int start = 0; start < str.length(); start++) {
            for (int end = start + 1; end <= str.length(); end++) {
                substrings.add(str.substring(start, end));
            }
        }
        return substrings;
    }
}
