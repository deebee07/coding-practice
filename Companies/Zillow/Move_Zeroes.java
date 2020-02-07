/*
https://leetcode.com/problems/move-zeroes/
*/

class Solution {
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;        
    
        int index = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }        
    
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
    }