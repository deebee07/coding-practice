/*
    Memoization 
    Time: O(N)
*/
class Fibonacci {

    public int CalculateFibonacci(int n) {
      int dp[] = new int[n + 1];
      return CalculateFibonacciRecursive(dp, n);
    }
  
    public int CalculateFibonacciRecursive(int[] dp, int n) {
      if (n < 2)
        return n;
      if (dp[n] == 0)
        dp[n] = CalculateFibonacciRecursive(dp, n - 1) + CalculateFibonacciRecursive(dp, n - 2);
      return dp[n];
    }
  
    public static void main(String[] args) {
      Fibonacci fib = new Fibonacci();
      System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
      System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
      System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
  }
  