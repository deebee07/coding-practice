/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Brute-Force
O(N^2)
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices == null) throw new IllegalArgumentException("Array passed is null");
        if (prices.length == 0) return 0;
        int n = prices.length;
        int maxProfit = 0;
        
        
        for(int i=0; i <= n-1; i++){
            
            for (int j=0;j<i;j++) {
                int profit = prices[i]-prices[j];
                System.out.println(profit);
                if (profit>0 && profit>maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
        
    }
}



class Solution {

    public int maxProfit(int prices[]) {
        if (prices == null) throw new IllegalArgumentException("Array passed is null");
        if (prices.length == 0) return 0;
        /*
        We are only interested in peaks; minimum and maximum value
        */
        int curMinPrice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < curMinPrice)
                curMinPrice = prices[i]; //update curMinPrice
            else if (prices[i] - curMinPrice > maxprofit)
                maxprofit = prices[i] - curMinPrice; // update maxProfit when proces
        }
        return maxprofit;
    }
}