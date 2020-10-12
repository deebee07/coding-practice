/*
https://leetcode.com/explore/interview/card/amazon/80/dynamic-programming/899/
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