
### Recursion:
METHOD that calls smaller versions of itself in order to get a solution.

SLOWER than Stacks or Iterative Solutions.

#### SIGNS We Need Recursion
* **Unsure** how many **loops** needed to solve problem.
* **Deeply nested data structures** are present.
* MULTIPLE branching CASES. (Traverse Tree/Graph).
* Iterative Solution is COMPLEX to implement.


## Building Blocks of Recursion
* **SCOPE VARIABLES:** VARIABLES ACCESSED via PARENT SCOPE. (Can be accessed in child)
* **BASE CASE:** TERMINATING case of the recursive method.
* **RECURSIVE CASE:** SITUATION where method calls itself.
* **STATE:** VALUES used to track progress of recursive method. ( Applies to recursive methods )
* **HELPER METHOD:** A PRIVATE METHOD to HANDLE RECURSIVE CALLS.

#### Top Down Recursion:
* Starts at **inputCase**...............**PERFORMS OPERATIONS**...........calls itself recursively until **BASE CASE** is REACHED.

#### Bottom Up Recursion:
* Starts at **baseCase**...............**PERFORMS OPERATIONS**...........calls itself recursively until **INPUT CASE** is REACHED.


## Single Recursion Vs Multiple Recursion
When each recursive case calls itself once. (Single Recursion)

When each recursive case calls itself multiple times creates a branching effect. (Multiple Recursion)


#### Recursion Help:
1. https://softwareengineering.stackexchange.com/questions/25052/in-plain-english-what-is-recursion
2. https://www.khanacademy.org/computing/computer-science/algorithms/recursive-algorithms/a/recursion