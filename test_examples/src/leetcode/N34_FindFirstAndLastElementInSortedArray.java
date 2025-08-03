package leetcode;

/*
* 34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

* Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

* Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

* Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
* */

import java.util.ArrayList;
import java.util.List;

public class N34_FindFirstAndLastElementInSortedArray {
    public static void main(String[] args) {

        var array = List.of(5,7,7,8,9,9,8,8,8,10);
        int target = 8, first = -1, last = -1;
        for (int i=0;i<array.size();i++) {
            if (first == -1 && array.get(i) == target) {
                first = i;
            } else if (array.get(i) == target) {
                last = i;
            }
        }
        System.out.println(first+" "+last);
    }
}
