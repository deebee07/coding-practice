/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
*/

/*
Initiate start to be equal to 0, and end to be equal to n - 1.
standard binary search. While start <= end:
    middle mid as a pivot:
    If nums[mid] == target, return mid
    Pivot element is larger than the first element in the array, MID > START (NOT-ROTATED)
        IF TARGET IN NON-ROTATED PART: end = mid-1 (Go Left)
        OTHERWISE GO RIGHT: start = mid + 1
*/
class Solution {
    public int search(int[] nums, int target) {
      int start = 0, end = nums.length - 1;
        
        
      while (start <= end) {
        int mid = (start + end) / 2;
  
        if (nums[mid] == target) return mid; // if element at mid is target return midIndex
  
        else if (nums[mid] >= nums[start]) { // if element at MID > element at START (NON ROTATED)
            
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

  class Solution {
    public boolean search(int[] nums, int target) {
    int start  = 0, end = nums.length - 1;
    
    //check each num so we will check start == end
    //We always get a sorted part and a half part
    //we can check sorted part to decide where to go next
    while(start <= end){
        int mid = (start + end)/2;
        if(nums[mid] == target) return true;
        
        //if left part is sorted
        if(nums[start] < nums[mid]){
            if(target < nums[start] || target > nums[mid]){
                //target is in rotated part
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }else if(nums[start] > nums[mid]){
            //right part is rotated
            
            //target is in rotated part
            if(target < nums[mid] || target > nums[end]){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }else{
            //duplicates, we know nums[mid] != target, so nums[start] != target
            //based on current information, we can only move left pointer to skip one cell
            //thus in the worest case, we would have target: 2, and array like 11111111, then
            //the running time would be O(n)
            start ++;
        }
    }
    
    return false;
}
}