/*
Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.

Example 1:

n : 4
Number of ways = 4
Explanation: Following are the four ways we can exoress 'n' : {1,1,1,1}, {1,3}, {3,1}, {4} 

Time: O(3^N)
*/

class ExpressNumber {

    public int CountWays(int n) {
      if( n == 0)
        return 1; // base case, we don't need to subtract any thing, so there is only one way
  
      if(n == 1)
        return 1; // we can subtract 1 to be left with zero, and that is the only way
  
      if(n == 2)
        return 1; // we can subtract 1 twice to get zero and that is the only way
  
      if(n == 3)
        return 2; // '3' can be expressed as {1,1,1}, {3}
        
      // if we subtract 1, we are left with 'n-1'
      int subtract1 = CountWays(n-1);
      // if we subtract 3, we are left with 'n-3'
      int subtract3 = CountWays(n-3);
      // if we subtract 4, we are left with 'n-4'
      int subtract4 = CountWays(n-4);
  
      return subtract1 + subtract3 + subtract4;
    }
  
    public static void main(String[] args) {
      ExpressNumber en = new ExpressNumber();
      System.out.println(en.CountWays(4));
      System.out.println(en.CountWays(5));
      System.out.println(en.CountWays(6));
    }
  }
  