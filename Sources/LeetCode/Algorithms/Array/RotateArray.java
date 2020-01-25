/*
https://leetcode.com/problems/rotate-array/
*/

/*
Approach: Using Reverse 
Time complexity : O(n): n elements are reversed a total of three times.
Space complexity : O(1)O(1). No extra space is used.

When we rotate the array k times:
    k elements from the back end of the array come to the front
        Rest of the elements from the front shift backwards.
       
       n=7
       k=3  k steps can be greater than arrayLength
Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
*/

class Solution {
    public void rotate(int[] nums, int k) {
        /*
        k steps can be greater than ArrayLength so by % we eventually get the count of k in terms of arrayElements to be            rotated
        */
        k= k%nums.length; // This will help us understand how many elements will go in the front of the Array
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}