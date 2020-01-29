/*
https://leetcode.com/explore/interview/card/microsoft/47/sorting-and-searching/193/
https://leetcode.com/problems/sort-colors/
*/

/*
Dutch National Flag Problem Dijkstra
idea is to attribute a color to each number and then to arrange them following the order of colors on the Dutch flag.
*/

class Solution {
    /*
    Dutch National Flag problem solution.
    */
    public void sortColors(int[] nums) {
  
      int left = 0, curr = 0;
  
      int right = nums.length - 1;
  
      int tmp;
      while (curr <= right) {
        if (nums[curr] == 0) { //left is for color 0
  
          tmp = nums[left];
          nums[left] = nums[curr];
          nums[curr] = tmp;
          left++;
          curr++;
        }
        else if (nums[curr] == 2) { //right is for color 2
  
          tmp = nums[curr];
          nums[curr] = nums[right];
          nums[right] = tmp;
          right--;

        }
        else curr++;
      }
    }
  }



  class Solution {
    /*
    Dutch National Flag problem solution.
    */
    public void sortColors(int[] nums) {
      // for all idx < i : nums[idx < i] = 0
      // j is an index of element under consideration
      int p0 = 0, curr = 0;
      // for all idx > k : nums[idx > k] = 2
      int p2 = nums.length - 1;
  
      int tmp;
      while (curr <= p2) {
        if (nums[curr] == 0) {
          // swap p0-th and curr-th elements
          // i++ and j++
          swap(p0, curr, nums);
          p0++;
          curr++;
        }
        else if (nums[curr] == 2) {
  
          swap(p2, curr, nums);
          p2--;
        }
        else curr++;
      }
    }
      
      public void swap(int i, int j, int[] nums){
          
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }
  }