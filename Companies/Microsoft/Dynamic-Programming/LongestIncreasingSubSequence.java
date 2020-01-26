/*
https://www.youtube.com/watch?v=fV-TF4OvZpk
LONGEST INCREASING SUBSEQUENCE
SEQUENCE IN ORDER
https://leetcode.com/problems/longest-increasing-subsequence/solution/
Given an unsorted array of integers, find the length of longest increasing subsequence.
Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:
There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
*/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        Do a NULL check throw Exception 
        Do a Length 0 check return 0
        Declare an integer Array of inputArr size for dynamic programming
        BASE CASE: (As a single element array would always be longest)
            dp[0] = 1 initialize 
            maxAns = 1
        iterate over i length: 1 till endIndex:
            maxVal = 0
            iterate over j: length 0 to i
                compare array[i] with array[j] if element at i greater than element at j
                    maxVal would be whatever between maxVal or dp[j]
            dp[i] = maxVal + 1; // for length
            maxAns = Math.max(maxAns, dp[i]);
        return maxAns;
        */
        if (nums == null) throw new IllegalArgumentException("Illegal args passed as array is null");
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0; // maximum possible for i are 0 initially till we iterate over j
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}