/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int curMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i<prices.length;i++) {
            if (curMin > prices[i]){
                curMin = prices[i];
            } else if ((prices[i]-curMin) > maxProfit) {
                maxProfit = (prices[i]-curMin);
            }
        }
        return maxProfit;
    }
}

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
You may complete at most two transactions.
*/
class Solution {
    public int maxProfit(int[] prices) {
        int buyOne = Integer.MAX_VALUE;
		int ProfitOne = 0;               // Profit gained after selling 1st share.
        int buyTwo = Integer.MAX_VALUE;
        int ProfitTwo = 0;               // Profit gained after selling 2nd share.
        for(int p : prices) {
            buyOne = Math.min(buyOne, p);
            ProfitOne = Math.max(ProfitOne, p - buyOne);
            buyTwo = Math.min(buyTwo, p - ProfitOne);     // If I made $100 profit in 1st trans'. Then the 2nd Stock(maybe $300) I buy is actually $300 - $100 = $200 for me. 
            ProfitTwo = Math.max(ProfitTwo, p - buyTwo);   // And finally The maximum profit I make with the 2nd trans' is my actuall profit with 2 transaction. 
        }
        return ProfitTwo;
    }
}
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
Design an algorithm to find the maximum profit. You may complete at most k transactions.
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54191/3ms-Java-DP-solution-beats-96.3.-O(kn)-time-O(n)-space.
*/


public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0) return 0;
        int len = prices.length;
        
        if(k >= len/2) {
            int maxPro = 0;
            for(int i=1; i < len; i++)
                if(prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            return maxPro;
        }
        
        int[] dp = new int[2*k];
        for(int i=0; i < k; i++) {
            dp[i*2] = Integer.MIN_VALUE;
            dp[2*i+1] = 0;
        }
        
        for(int price : prices) {
            if(dp[0] < -price) dp[0] = -price;
            int sign = 1;
            
            for(int i=1; i < 2*k; i++) {
                int tmp = dp[i-1] + sign*price;
                if(dp[i] < tmp) dp[i] = tmp;
                sign *= -1;
            }
        }
        
        return dp[2*k-1];
    }
}