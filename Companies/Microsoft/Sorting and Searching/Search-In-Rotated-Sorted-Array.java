/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
*/
class Solution {
    public int search(int[] nums, int target) {
      int start = 0, end = nums.length - 1;
        
        
      while (start <= end) {
        int mid = (start + end) / 2;
  
        if (nums[mid] == target) return mid; // if element at mid is target return midIndex
  
        else if (nums[mid] >= nums[start]) { // SORTED if element at MID > element at START (NON ROTATED)
            
          if (target >= nums[start] && target < nums[mid]) end = mid - 1; // Go LEFT (SORTED)
          else start = mid + 1; // Go RIGHT
        }
        else { // if element at MID < element at START (ROTATED)
          if (target <= nums[end] && target > nums[mid]) start = mid + 1;
          else end = mid - 1;
        }
      }
      return -1;
    }
  }