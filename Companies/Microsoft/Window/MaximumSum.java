/*
https://leetcode.com/problems/maximum-subarray/
Time: O(n)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int localSum = nums[0]; 
        int globalSum = nums[0];
        
        for(int i=1; i<n;i++) {
            localSum = Math.max(nums[i], localSum+nums[i]);
            globalSum = Math.max(localSum, globalSum);
        }
        return globalSum;
        
    }
}

/*
Dynamic Programming (Kadane's algorithm)
Input:    [5,6,7,1,2,3,8]
localMax: [5,11,18,19,21,24,32]
globalMax:[5,11,18,19,21,24,32]

Input:    [-2,1,-3,4,-1,2,1,-5,4]
localMax: [-2,1,-2,4,3,5,6,1,5]
globalMax:[-2,1,1,4,4,5,6,6,6]
*/