Problem Statement <br>
Given a stair with ‘n’ steps, implement a method to count how many possible ways are there to reach the top of the staircase, given that, at every step you can either take 1 step, 2 steps, or 3 steps.

Example 1:

Number of stairs (n) : 3
Number of ways = 4
Explanation: Following are the four ways we can climb : {1,1,1}, {1,2}, {2,1}, {3}




Fibonacci number pattern here : <br>
 ```CountWays(n) = CountWays(n-1) + CountWays(n-2) + CountWays(n-3), for n >=3```
This problem can be extended further. Instead of taking 1, 2, or 3 steps at any time, what if we can take up to ‘k’ steps at any time? In that case, our recursive formula will look like:

```CountWays(n) = CountWays(n-1) + CountWays(n-2) + CountWays(n-3) + ... + CountWays(n-k), for n >= k```