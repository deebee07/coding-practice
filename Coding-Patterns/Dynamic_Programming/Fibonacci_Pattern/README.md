Fibonacci numbers are a series of numbers in which each number is the sum of the two preceding numbers.

The first few Fibonacci numbers are 0, 1, 1, 2, 3, 5, and 8, and they continue on from there.

```Fib(n) = Fib(n-1) + Fib(n-2), for n > 1```


Recursion Tree
Characteristics of Dynamic Programming

1. Overlapping Problems (Smaller versions of original problem)
2. Optimal Substructure Property

Any problem has optimal substructure property if its overall optimal solution can be constructed from the optimal solutions of its subproblems. For Fibonacci numbers, as we know,

Fib(n) = Fib(n-1) + Fib(n-2)

Dynamic Programming Methods
DP offers two methods to solve a problem.

1. Top-down with Memoization:
    we cache its result so that we don’t end up solving it repeatedly if it’s called multiple times. Instead, we can just return the saved result. This technique of storing the results of already solved subproblems is called Memoization.

2. Bottom-up with Tabulation:
    Tabulation is the opposite of the top-down approach and avoids recursion. In this approach, we solve the problem “bottom-up” (i.e. by solving all the related sub-problems first). This is typically done by filling up an n-dimensional table. Based on the results in the table, the solution to the top/original problem is then computed.