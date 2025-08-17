package leetcode;

/*
* 21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of
*  the first two lists.
Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
* */

import java.util.*;

public class N21_MergeTwoSortedList {
    public static void main(String[] args) {

        var l1 = new LinkedList<>(List.of(1,2,4));
        var l2 = new LinkedList<>(List.of(1,3,4));

        l1.addAll(l2);
        Collections.sort(l1);
        System.out.println(l1);

        var s1 = new HashSet<>(Set.of(1,22,4,5,7));
        System.out.println(new TreeSet<>(s1));

    }
}
