https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns
https://leetcode.com/discuss/general-discussion/494279/comprehensive-data-structure-and-algorithm-study-guide


https://www.youtube.com/playlist?list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O


Programming approach to solve problems in subsets.

DP uses simpler subsets.

2 Characterstics:
    1. Overlapping subproblems
    2. It should have optimal substructure

Drastically reduce time complexity


**Two types of Dynamic Programming:**
    1. Memoization <br>
        Top-down approach <br>
        Typically recursion with a cache <br>
    2. Tabulation <br>
        Bottom-up approach <br>
        Typically iterative <br>

**Memoization:** <br>
    Optimization technique using to cache results. <br>
    **Ways to implement memoization**
Helper method recursion: <br>
    1. Create a scope variable to store results. <br>
    2. Set logic to check if a subsproblem has been solved prior to computing it. <br>
Separate function Decorator <br>
    1. Create cache scope variable.
    2. Logic to check for previously computed results


Example fibonacci if we using memoization

Normally :O(2^n)

With memoization
    Each case computed once:
        O(n)


Tabulation <br>
Bottom up approach <br>
Optimization technique that uses subproblem solutions to build up to a solution.


Understand the starting point:
    Base Case
    Not input Case
See if the smallest problem can be used to solve the next level up

Have a path to reach inputCase

Paths in Triange get maximum.

O(N)

Memoization vs Tabulation

Memoization:
    Avoid unnecessary sub-computations
    Cost more space
    Doesnt require a change in recursive algorithm
    Always must check cache

Tabulation:
    change algorithm from top-down recursion to implement tabulation.
    Must compute all sub-computations.
        cannot skip to only needed sub-computations.
    no checking cache each sub-computation
    can maintain efficient spae complexity by discarding unneeded sub-solutions.

How do I get better ?
    No road map to solver DP problems
    Investigate multiple recursion problems
        draw tree and see if there are same subproblems
            look for overlaps
        solve it recursively first
    Implement a cache using memoization
    See if you can work from the base using tabulations (Base  Case -> Input Case)

    Do problems that are known to have DP solutions


**Dynamic Programming (DP)** is an algorithmic technique for solving an **optimization problem** by breaking it down into **simpler subproblems** and **utilizing the fact that the optimal solution** to the overall problem depends upon the **optimal solution** to its subproblems.


