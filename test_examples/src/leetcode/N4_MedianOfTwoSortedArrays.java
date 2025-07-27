package leetcode;

/*
4. Median of Two Sorted Arrays
* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class N4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = { 1, 2, 13, 14, 5, 6, 7, 8, 9 };
        int[] b = { 1, 2, 3, 4, 5, 16, 7, 8, 19 };

        double medianSumOfTwoArrays = 0.0;
        var arrayList = new ArrayList<Integer>();

        for (int j : a) arrayList.add(j);
        for (int j : b) arrayList.add(j);

        Collections.sort(arrayList);
        System.out.println(arrayList);
        for (int i : arrayList) {
            medianSumOfTwoArrays += i;
        }
        System.out.println("sum = " + medianSumOfTwoArrays);
        System.out.println("count = " + arrayList.size());
        medianSumOfTwoArrays = medianSumOfTwoArrays / arrayList.size();
        System.out.println(medianSumOfTwoArrays);
    }
}
