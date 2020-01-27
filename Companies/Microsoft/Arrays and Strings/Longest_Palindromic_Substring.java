/*
https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/180/


For every position i we're interested if there's a palindrome ending at this position (inclusive) longer than the longest palindrome found so far.

For i = 0 Only palindrome ending there is the palindrome of length 1. New palindrome has length 1 and therefore the maximum increases by 1.

For every i > 0 we can have many palindromes ending there. We're only interested in those with length >= 2 because we've already found one of length 
1. Some of palindromes may have even lengths, some odd. 

Presence of a palindrome of length len >= 2 ending at i implies three things:
i - len + 1 >= 0 (obviously).
s[i - len + 1] == s[i].
s[i - len + 2 .. i - 1] is a palindrome. This is the most interesting fact because it means that if we have found a palindrome of length len - 2 ending at i - 1, then we may find another one of length len ending at i. So incrementing i by 1 can lead to increase of the palindrome length by 2. One more important corollary: if we find a palindrome of length len - 2 at i - 1, then we only need to check the conditions (1) and (2) above on the next iteration—we may skip the isPalindrome() call.
Now consider the following loop invariant: just prior to the first iteration, and right after each iteration (after incrementing i) max is the length of the longest palindrome substring within the substring s[0..i) (exclusive). Let's deal with it rigorously, CLR-style:

Initialization. This is obviously true for i = 0 if we initialize max = 0.
The longest palindrome substring of an empty string s[0..0) is an empty string.
Maintenance. Suppose max is the longest palindrome substring of s[0..i). 
Then for s[0..i+1) we only need to consider palindromes ending at s[i] (inclusive), because we've checked all others already. F
rom the fact (3) above it follows that we can only find palindromes of length max + 1 or max + 2 ending there. 

Indeed, if we were able to find a palindrome of length max + l (l > 2) ending at i, then it would mean that there is a palindrome of length max + l - 2 > max ending at i - 1, 

which contradicts the assumption that max is the maximum length of a palindrome found so far.
Termination. Since the substring s[0..N) (N = length of s) is the string s itself, then max is the length of the longest palindrome substring. If we keep track of starts/ends, we can easily get the substring itself.
My code based on the above is given below. It differs from the solution presented in the question only in that it tries to optimize palindrome checks by using the fact (3) for the case when the previous palindrome is at i - 1. This improves performance by 2 ms (total 7 ms, beating 99%).

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
O(n^2)
*/

public class Solution {
    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        int palindromeStartsAt = 0, maxLen = 0;

        boolean[][] dp = new boolean[n][n];
        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
        
        for(int i = n-1; i >= 0; i--) { // keep increasing the possible palindrome string
            for(int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)
                
                //check if substring between (i,j) is palindrome
                dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
                           && 
                           ( j-i < 3  // if window is less than or equal to 3, just end chars should match
                             || dp[i+1][j-1]  ); // if window is > 3, substring (i+1, j-1) should be palindrome too
                
                //update max palindrome string
                if(dp[i][j] && (j-i+1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt+maxLen);
    }
}

//O(n cube) O(n^3)
class Solution {
    public String longestPalindrome(String s) {

        char[] charArray = s.toCharArray();
        String longestPalindrome = ""; // one length is always palindrome
        int maxLength = 0;
        
        for(int i=0;i<s.length();i++) {
            if (isPalindromic(charArray, i-maxLength-1, i)) { //either current maxLength-1 to i value
                longestPalindrome = s.substring(i-maxLength-1, i+1);
                maxLength = maxLength+2; //increment by 2
            } else if (isPalindromic(charArray, i-maxLength, i)) { //either current maxLength to i value 
                longestPalindrome = s.substring(i-maxLength, i+1);
                maxLength = maxLength+1; //increment by 1 
            }
        }
        return longestPalindrome;
        
    }
    
    public boolean isPalindromic(char[] charArray, int left, int right) {
        
        if(left<0 || right>charArray.length-1) {
            return false;
        }
        
        while (left<right){
            if (charArray[left]==charArray[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}