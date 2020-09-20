/*

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
*/

class Solution {
// Shift non-zero values as far forward as possible
// Fill remaining space with zeros

public void moveZeroes(int[] nums) {
    /*
    if nums == null or nums.length == 0 return
    int index = 0
    
    for (int num: nums) {
        if (num != 0) {
            nums[i] = num;
            index++;
        }
    }
    
    while (index<nums.length) {
        nums[index] = 0;
        index++;
    }
    
    }
    */
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