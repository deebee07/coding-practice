class HouseThief {

    public int findMaxSteal(int[] wealth) {
      int dp[] = new int[wealth.length];
      return findMaxStealRecursive(dp, wealth, 0);
    }
  
    private int findMaxStealRecursive(int[] dp, int[] wealth, int currentIndex) {
      if(currentIndex >= wealth.length)
        return 0;
  
      if(dp[currentIndex] == 0) {
        // steal from current house and skip one to steal next
        int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(dp, wealth, currentIndex + 2);
        // skip current house to steel from the adjacent house
        int skipCurrent = findMaxStealRecursive(dp, wealth, currentIndex + 1);
  
        dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
      }
      return dp[currentIndex];
    }
  
    public static void main(String[] args) {
      HouseThief ht = new HouseThief();
      int[] wealth = {2, 5, 1, 3, 6, 2, 4};
      System.out.println(ht.findMaxSteal(wealth));
      wealth = new int[]{2, 10, 14, 8, 1};
      System.out.println(ht.findMaxSteal(wealth));
    }
  }
  
  