/*

Problem Statement
Given a number array representing the wealth of ‘n’ houses, determine the maximum amount of money the thief can steal without alerting the security system.
*/


class HouseThief {

    public int findMaxSteal(int[] wealth) {
      return findMaxStealRecursive(wealth, 0);
    }
  
    private int findMaxStealRecursive(int[] wealth, int currentIndex) {
      if( currentIndex >= wealth.length)
        return 0;
  
      // steal from current house and skip one to steal from the next house
      int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(wealth, currentIndex + 2);
      // skip current house to steel from the adjacent house
      int skipCurrent = findMaxStealRecursive(wealth, currentIndex + 1);
  
      return Math.max(stealCurrent, skipCurrent);
    }
  
    public static void main(String[] args) {
      HouseThief ht = new HouseThief();
      int[] wealth = {2, 5, 1, 3, 6, 2, 4};
      System.out.println(ht.findMaxSteal(wealth));
      wealth = new int[]{2, 10, 14, 8, 1};
      System.out.println(ht.findMaxSteal(wealth));
    }
  }
  
  