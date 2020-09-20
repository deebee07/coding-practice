/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3285/

Time complexity :O(N)

Space complexity : O(1)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int localMaxSum = nums[0];
        int globalMaxSum = nums[0];
        
        for(int i=1; i<nums.length;i++) {
            localMaxSum = Math.max(nums[i], nums[i]+localMaxSum);
            globalMaxSum = Math.max(globalMaxSum, localMaxSum);
        }
        
        return globalMaxSum;
        
    }
}