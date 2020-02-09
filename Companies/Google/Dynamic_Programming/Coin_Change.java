/*
Declare dpArray of length amount + 1
Declare max with amount + 1
Arrays.fill(dpArray, max)
dpArray[0] = 0

iterate over amount from 1 to amount (i)
    iterate over coins from 0 to coins.length-1 (j)
        if (coins[j]<=i){
            dp[i] = Math.min(dp[i], dp[i-coins[j]]+1)
        }
        
For the iterative solution, we think in bottom-up manner. 
Before calculating F(i), we have to compute all minimum counts for amounts up to i.
On each iteration i of the algorithm F(i) is computed as minj=0..n-1 F(i -c_j)} + 1
j=0…n−1
​	
 F(i−c 
j
​	
 )+1
*/
public class Solution {
    public int coinChange(int[] coins, int amount) {
      int max = amount + 1;
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, max);
      dp[0] = 0; // 0 amount 0 ways
      for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
            
          if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }
  
        }
      }
      return dp[amount] > amount ? -1 : dp[amount];
    }
  }