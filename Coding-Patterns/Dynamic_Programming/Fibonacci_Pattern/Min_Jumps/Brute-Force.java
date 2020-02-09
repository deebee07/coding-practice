/*
Given an array of positive numbers, where each element represents the max number of jumps that can be made forward from that element;
write a program to find the minimum number of jumps needed to reach the end of the array 
(starting from the first element). If an element is 0, then we cannot move through that element.

Input = {2,1,1,1,4}
Output = 3
Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
Basic Solution
We will start with the '0’th index and try all options. 
So, if the value at the current index is ‘p’, we will try every jump in the range (1 to ‘p’) from that index.
After taking a jump, we recursively try all option from that index.
*/
class ArrayJump {

    public int countMinJumps(int[] jumps) {
      return this.countMinJumpsRecursive(jumps, 0);
    }
  
    private int countMinJumpsRecursive(int[] jumps, int currentIndex) {
      // if we have reached the last index, we don't need any more jumps
      if( currentIndex == jumps.length - 1)
        return 0;
  
      if (jumps[currentIndex] == 0)
        return Integer.MAX_VALUE;
  
      int totalJumps = Integer.MAX_VALUE;
      int start = currentIndex + 1;
      int end = currentIndex + jumps[currentIndex];
      while(start < jumps.length && start <= end) {
        // jump one step and recurse for the remaining array
        int minJumps = countMinJumpsRecursive(jumps, start++);
        if(minJumps != Integer.MAX_VALUE)
          totalJumps = Math.min(totalJumps, minJumps + 1);
      }
      return totalJumps;
    }
  
    public static void main(String[] args) {
      ArrayJump aj = new ArrayJump();
      int[] jumps = {2, 1, 1, 1, 4};
      System.out.println(aj.countMinJumps(jumps));
      jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
      System.out.println(aj.countMinJumps(jumps));
    }
  }