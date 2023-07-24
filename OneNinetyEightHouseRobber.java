/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } 

        int[] dp = new int[nums.length];

        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = nums[nums.length-2];
        dp[nums.length-3] = nums[nums.length-3] + nums[nums.length-1];    


        for (int i = nums.length-4; i >= 0; i--) {

            dp[i] = nums[i] + Math.max(dp[i+2], dp[i+3]);

        }

        return Math.max(dp[0], dp[1]);

    }
}
