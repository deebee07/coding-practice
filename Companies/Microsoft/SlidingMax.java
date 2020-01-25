/*
https://leetcode.com/problems/sliding-window-maximum/
Time complexity : O(Nk)
Space complexity: O(N−k+1)

*/
//Use a hammer

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0]; //if windowSize is 0 or arrayLength is - return emptyArray
        
        /*
        movesByWindow are n-k+1
        */
        int [] output = new int[n - k + 1]; // k will act as 1 element so nLength -k+1 (+1 for firstWindow)
        
        
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) 
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
}



/*
Iterate along the array in the direction left->right and build an array left.

Iterate along the array in the direction right->left and build an array right.

Build an output array as max(right[i], left[i + k - 1]) for i in range (0, n - k + 1).
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0]; //if windowSize is 0 or arrayLength is - return emptyArray
        if (k==1) return nums;
        
       int[] left = new int[n];
        left[0]= nums[0];
        
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        
        for (int i = 1; i < n; i++) {
          // from left to right start maximum
          if (i % k == 0) left[i] = nums[i];  // block_start initialize
          else left[i] = Math.max(left[i - 1], nums[i]); //maxof each element you come across from left

          // from right to left end maximum
          int j = n - i - 1;
          if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
          else right[j] = Math.max(right[j + 1], nums[j]);//maxof each element you come across from right
        }
        
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);
        return output;
    }
}