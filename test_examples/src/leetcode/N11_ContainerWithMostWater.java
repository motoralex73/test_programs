package leetcode;

/*
* 11. Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such
* that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
*
* Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area
* of water (blue section) the container can contain is 49.
Example 2:
Input: height = [1,1]
Output: 1
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class N11_ContainerWithMostWater {

    public static void main(String[] args) {

        int[] arr = {1,8,6,2,5,4,8,3,7};
        int s = 0;

        Vector<Integer> vec = new Vector<>();
        for (int j = 0; j <= arr.length-2; j++) {
            for (int i = j; i < arr.length-1; i++) {
                if(arr[j] < arr[i+1])
                    s = arr[j]*(i+1-j);
                if(arr[j] > arr[i+1])
                    s = arr[i+1]*(i+1-j);
                vec.add(s);
            }
        }

        var list = new ArrayList<>(vec);
        for(var elem : vec){
            System.out.println("vec= "+elem);
        }

        Collections.sort(list);
        System.out.println("Max value of BlueWaterBox= "+ list.getLast());
    }
}
