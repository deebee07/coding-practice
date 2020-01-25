/*
Smallest Subarray with a given sum
https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
Example 1:
Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
Example 2:
Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

Time Complexity: O(N)
Space Complexity: O(1)
*/

class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
      int windowSum = 0, minLength = Integer.MAX_VALUE;
      int windowStart = 0;
      for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd]; // add the next element
        // SHRINK THE WINDOW by subtracting windowStart ELEMENT as small as possible until the 'windowSum' is smaller than 'S'
        while (windowSum >= S) {
          minLength = Math.min(minLength, windowEnd - windowStart + 1); // WINDOW SIZE WOULD BE windowEnd - windowStart + 1
          windowSum -= arr[windowStart]; // subtract the element going out
          windowStart++; // slide the window ahead
        }
      }
      return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
  
    public static void main(String[] args) {
      int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
      System.out.println("Smallest subarray length: " + result);
      result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
      System.out.println("Smallest subarray length: " + result);
      result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
      System.out.println("Smallest subarray length: " + result);
    }
  }