Data stream model

In the data stream model, some or all of the input is represented as a finite sequence of integers (from some finite domain) which is generally not available for random access.




Instead arrives one at a time in a "stream".[4] If the stream has length n and the domain has size m, algorithms are generally constrained to use space that is logarithmic in m and n. They can generally make only some small constant number of passes over the stream, sometimes just one.[5]


Google likes to test your ability to think at large scale by asking variation of problems represented in a data stream model

For example, instead of giving you an integer array, you are given a stream of integers and all integers are too large to fit in memory.

https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/