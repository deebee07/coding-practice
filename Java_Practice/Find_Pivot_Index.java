/*
https://leetcode.com/problems/find-pivot-index/
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.

*/

class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum * 2 == total + nums[i]) {
                return i;
            }
        }
        return -1;
    }
}