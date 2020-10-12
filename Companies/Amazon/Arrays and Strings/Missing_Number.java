/*
https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2971/
*/
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}