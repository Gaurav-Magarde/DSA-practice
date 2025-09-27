package LeetCode.Array.PrefixSum;

import java.util.List;

//   LeetCode 2848. Points That Intersect With Cars
 
//   You are given a 0-indexed 2D integer array nums representing the coordinates of the cars parking on a number line. For any index i, nums[i] = [starti, endi] where starti is the starting point of the ith car and endi is the ending point of the ith car.

//   Return the number of integer points on the line that are covered with any part of a car.

//   Tc - O(n + 101)
//   Sc - O(1)



public class PointInterectWithCar {
    public int numberOfPoints(List<List<Integer>> nums) {
        int  n = nums.size();
        int[] prefix = new int[102];

        for(int i = 0;i<n;i++){
            int start = nums.get(i).get(0);
            int end = nums.get(i).get(1);
            prefix[start] += 1;
             prefix[end+1] += -1;
        }

        int parking  = 0;
        for(int i = 1;i<=100;i++){
            prefix[i] += prefix[i-1];
            if(prefix[i]>0) parking++;
        }
        return parking;
    }
}
