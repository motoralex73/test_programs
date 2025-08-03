package leetcode;

/*
* 35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

* Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

* Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

* Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N35_SearchInsertPosition {
    public static void main(String[] args) {
        var list = List.of(1,3,7,11);
        int target = 12;
        int index = 0;

        for (int i=0;i<list.size();i++) {
            try {
                if (list.getLast() >= list.get(i + 1) && list.get(i) < target && list.get(i + 1) > target)
                    index = i + 1;
            }
            catch(Exception e) {
                index = i + 1;
            }
        }

        System.out.println(index);
    }
}
