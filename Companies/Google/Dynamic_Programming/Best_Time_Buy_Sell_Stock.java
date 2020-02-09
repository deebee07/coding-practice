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