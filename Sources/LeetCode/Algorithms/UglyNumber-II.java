/* 
TECHNIQUE: Looping w/ Multiple Pointers i2, i3, i5
https://leetcode.com/problems/ugly-number-ii/
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers

Note:
1 is typically treated as an ugly number.
n does not exceed 1690.

Dynamic Programming:
ALgorithm:
Precompute all 1690:
    nums[] array of length 1690, Initialize indexFor2, indexFor3, indexFor5 as 0
    nums[0] = 1
    iterate over 1 to < 1690
        Put n[nextIndex] min(i2*2, i3*3, i5*5)
        update i2/i3/i5 based on min

Complexity Analysis

Time complexity : O(1) to retrieve preliminary computed ugly number, and 1690 * 5 = 8450 operations.
Space complexity : O(1) Array of 1690 ugly numbers


*/
class UglyNumbers {
  public int[] nums = new int[1690];
  UglyNumbers() {
    nums[0] = 1;
    int ugly, i2 = 0, i3 = 0, i5 = 0;

    for(int i = 1; i < 1690; ++i) {
      ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
      nums[i] = ugly;

      if (ugly == nums[i2] * 2) ++i2;
      if (ugly == nums[i3] * 3) ++i3;
      if (ugly == nums[i5] * 5) ++i5;
    }
  }
}

class Solution {
    
    public static UglyNumbers u = new UglyNumbers();
    public int nthUglyNumber(int n) {
        return u.nums[n-1];
        
    }
}
