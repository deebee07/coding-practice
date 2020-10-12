/*

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 

Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
Time complexity: O((N−L)L), where N is a length of haystack and L is a length of needle. 
compute a substring of length L in a loop, which is executed (N - L) times
https://leetcode.com/problems/implement-strstr/solution/

*/



class Solution {
    public int strStr(String haystack, String needle) {
        
        int L = needle.length();
        int N = haystack.length();
        if (L==N) return (haystack.equals(needle) ? 0 : -1);
        for (int i =0; i<N; i++) {
            if (i+L>N) {
                continue;
            }
            if(haystack.substring(i, i+L).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}