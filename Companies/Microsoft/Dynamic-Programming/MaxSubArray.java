/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums==null || nums.length ==0) throw new IllegalArgumentException("Illegal Arg passed");
        
        int n = nums.length;
        
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            curSum = Math.max(curSum+nums[i], nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}