/**
Given an integer array nums, find the subarray with the largest sum, and return its sum.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums.length == 1) 
            return nums[0];
        
        int[] fromRight = new int[nums.length];
        fromRight[nums.length-1] = nums[nums.length-1];
        int maxSum = nums[nums.length-1];
        
        for (int i = nums.length-2; i >= 0; i--) {
            if (fromRight[i+1] > 0)
                fromRight[i] = nums[i] + fromRight[i+1];
            else 
                fromRight[i] = nums[i];
            maxSum = Math.max(maxSum, fromRight[i]);
        }
        
        return maxSum;
        
    }
}
