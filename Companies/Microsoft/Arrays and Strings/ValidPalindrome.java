/*
https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/162/
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false

if s=null throw Exception
if s.isEmpty() return true

left is 0
right as s.length()-1

while(left<right){
    cLeft = s.charAt(left);
    cRight = s.charAt(right);

    if(Character.isLetterOrDigit(cLeft)){
        left++;
    } else if (Character.isLetterOrDigit(cRight)){
        right--;
    } else {
        if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
            return false;
        }
        left++;
        right--;
    }
}
return true;
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}