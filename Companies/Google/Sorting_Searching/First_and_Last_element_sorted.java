/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
Recommend against (int mid = (start + end) / 2) due to integer overflow possibilities.
Try (int mid = start + (end - start)/2);
or
int mid = (start + end) >>> 2; // >>> is logical shift so it does not extend the signed part

In details
if your (start + end) is greater than 2^31, it will be represented as 1111111111... and dividing it by 2 will mean keeping the signed number
To prevent overflow, you can use (long) or configure your algorithm to prevent it.
Just good practice to keep in mind
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
         // negative case
         if(nums.length == 0 || nums == null) return new int[]{-1,-1};
         int start = 0;
         int end = nums.length-1;
         while(start <= end) {
             // base case
             if(nums[start] == target && nums[end] == target) return new int[]{start, end};
             // increment, if the value of at the start index is less than the target
             if(nums[start] < target) start++;
             // decrement, if the value at the end index is greater than the target
             if(nums[end] > target) end--;
         }
         return new int[]{-1,-1};
     }
 }

 public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = findFirstLast(nums, target, true);
    result[1] = findFirstLast(nums, target, false);
    return result;
}

private int findFirstLast(int[] nums, int target, boolean first) {
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (target < nums[mid] || (first && target == nums[mid])) { 
            end = mid-1;
        }
        else {
            start = mid+1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}