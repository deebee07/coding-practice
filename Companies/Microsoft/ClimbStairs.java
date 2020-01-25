/*
https://leetcode.com/problems/climbing-stairs
Either 1 step or 2 step
*/
class Solution {
    public int climbStairs(int n) {
        return helper(0, n);
    }
    
    public int helper(int i, int n) {
        
        if(i>n) {
            return 0;
        }
        
        if(i==n) {
            return 1;
        }
        
        return helper(i+1, n) + helper(i+2, n);
    }
}


/*
Memoization
Time complexity : O(n)O(n). Size of recursion tree can go upto nn.

Space complexity : O(n)O(n). The depth of recursion tree can go upto nn.
*/

/*
https://leetcode.com/problems/climbing-stairs
Either 1 step or 2 step

Number of nodes O(2^n)
https://leetcode.com/problems/climbing-stairs/solution/

memo[0] = 0
memo[1] = 1
memo[2] = 2
memo[3] = 3
*/
class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        return helper(0, n, memo);
    }
    
    public int helper(int i, int n, int[] memo) {
        
        if(i>n) {
            return 0;
        }
        
        if(i==n) {
            return 1;
        }
        if(memo[i]>0) { // if we have had memoization then return memoization
            return memo[i];
        }
        memo[i] = helper(i+1, n, memo)+helper(i+2, n, memo);
        return memo[i];
    }
}
