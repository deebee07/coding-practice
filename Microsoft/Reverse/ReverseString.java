/*
https://leetcode.com/problems/reverse-string
*/
class Solution {
    public void reverseString(char[] s) {
        /*
        Recursion, IN-PLACE; O(N) Space
        */
        helper(s, 0, s.length-1);
    }
    
    
    public void helper(char[] s, int left, int right) {
        if (left>=right) return;
        char tmp = s [left];
        s[left] = s[right];
        s[right] = tmp;
        left++;
        right--; // replace left and right if we have unique different pointers
        helper(s, left, right); 
    }
}

/*

Non-Recursive Solution
*/
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;
        
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }
    
    
    public void swap(char[] s, int leftIndex, int rightIndex) {
        
        char temp = s[leftIndex];
        s[leftIndex] = s[rightIndex];
        s[rightIndex] = temp;
    }

}