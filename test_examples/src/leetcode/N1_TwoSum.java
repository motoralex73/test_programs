package leetcode;

import java.util.Arrays;

/*
* 1. Two Sum
Given an array of integers nums and an integer target,
* return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
* Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
* */

public class N1_TwoSum {

    static public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] pair = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    pair[0] = i;
                    pair[1] = j;
                    return pair;
                }
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        int[] array = {2,5,3,7,0,6};
        int target = 11;
        System.out.println(Arrays.toString(twoSum(array, target)));

    }
}
