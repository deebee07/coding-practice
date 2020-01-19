/*
https://leetcode.com/problems/largest-number-at-least-twice-of-others/
*/
class Solution {
    public int dominantIndex(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int maxIndex = -1;
        int max2Num = Integer.MIN_VALUE;
        int max2Index = -1;
        
        // get max
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        
        // get 2nd max
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>max2Num && i!=maxIndex) {
                max2Num = nums[i];
                max2Index = i;
            }
        }
        
        max2Num = 2*max2Num;
        
        if (maxNum>=max2Num) {
            return maxIndex;
        } else {
            return -1;
        }
        
    }
}