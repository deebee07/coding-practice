/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length ==0) throw new IllegalArgumentException("Illegal Arg passed");
        int len = nums.length;
        
        int[] L = new int[len];
        int[] R = new int[len];
        
        L[0] = 1;
        for(int i =1; i<len; i++) {
            L[i] = L[i-1]* nums[i-1];
        }
        
        R[len-1] = 1;
        for(int i =len-2; i>=0; i--) {
            R[i] = R[i+1] * nums[i+1];
        }
        
        int[] outputArr = new int[len];
        
        for(int i =0; i<len; i++) {
            outputArr[i] = L[i] * R[i];
        }
        return outputArr;
    }
}