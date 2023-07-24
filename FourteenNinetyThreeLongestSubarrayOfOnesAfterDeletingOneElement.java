/**
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
*/

class Solution {
    public int longestSubarray(int[] nums) {
        
        int indexOfZero = -1;
        int maxSize = 0;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { //find first zero
                indexOfZero = i;
                endIndex = i+1;
                maxSize = i+1;
                break;
            } else if (i == nums.length-1) { //no zeros
                return nums.length-1;
            }
        }

        for (; endIndex < nums.length; endIndex++) {

            if (nums[endIndex] == 0) {
                maxSize = Math.max(maxSize, endIndex-startIndex);
                startIndex = indexOfZero+1;
                indexOfZero = endIndex;
            } else if (endIndex == nums.length-1) {
                maxSize = Math.max(maxSize, endIndex - startIndex + 1);
            }

        }

        return maxSize-1;

    }
}
