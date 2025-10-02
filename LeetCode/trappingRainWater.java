//Leetcode 42 Trapping Rain Water

// Given n non-negative integers representing an elevation map where 
// the width of each bar is 1, compute how much water it can trap after raining.


class Solution {
    public int trap(int[] height) {
        int left = 0,right = height.length-1;
        int leftMax = height[0],rightMax = height[right];
        int total = 0;
        while(left<right){
            int currLeft = height[left];
            int currRight  = height[right];
            if(currLeft<currRight){
                if(currLeft>=leftMax){
                    leftMax = currLeft;
                }else{
                    total+=(leftMax-currLeft);
                }
                left++;
            }else{
                if(currRight>=rightMax){
                    rightMax = currRight;
                }else{
                    total+=(rightMax-currRight);
                }
                right--;
            }
        }
        return total;
    }
}