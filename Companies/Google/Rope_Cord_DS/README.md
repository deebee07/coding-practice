https://leetcode.com/discuss/interview-question/435536/Google-or-Onsite-or-Design-a-Cord



They asked me to implement: https://en.wikipedia.org/wiki/Rope_(data_structure)


 **ROPE OR CORD:** A DATA STRUCTURE COMPOSED OF **SMALLER STRINGS**; USED TO **STORE** AND **MANIPULATE** VERY LONG STRING.

EXAMPLE: Text Editing Program

1. A rope is a binary tree where each leaf (end node) holds a string and a length.

2. Each node further up the tree holds the sum of the lengths of all the leaves in its left subtree.

3. A node with two children thus divides the whole string into two parts: 
    1. the left subtree stores the first part of the string.
    2. the right subtree stores the second part of the string and node's weight is the sum of the left child's weight along with all of the nodes contained in its subtree.



    char_at(index) - easy got it quick. The solution is recursive.
    substring_at(start_index, end_index) - was able to explain in words but did not have for code. The solution is recursive.
https://leetcode.com/discuss/interview-question/413991/



https://www.geeksforgeeks.org/ropes-data-structure-fast-string-concatenation/

Ropes Data Structure

A Rope is a binary tree structure where each node except the leaf nodes, contains the number of characters present to the left of that node. Leaf nodes contain the actual string broken into substrings (size of these substrings can be decided by the user).

Advantages
    1. Ropes drastically cut down the cost of appending two strings.
    2. Unlike arrays, ropes do not require large contiguous memory allocations.
    3. Ropes do not require O(n) additional memory to perform operations like insertion/deletion/searching.
    4. In case a user wants to undo the last concatenation made, he can do so in O(1) time by just removing the root node of the tree.

Disadvantages
1. The complexity of source code increases.
2. Greater chances of bugs.
3. Extra memory required to store parent nodes.
4. Time to access i-th character increases.
