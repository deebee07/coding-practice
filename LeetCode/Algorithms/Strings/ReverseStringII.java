/*
https://leetcode.com/problems/reverse-string-ii/
*/
public class Solution {
    public String reverseStr(String s, int k) {
        /*
        Convert given String toCharArray
            n is lengthOfCharArray
            i starts from 0
            iterate until i<n
                whichever is min(i+k-1,n-1) i is inclusive this is why -1 // n-1 is remaining
                reverse(charArray, i,j)
                i is 2*k
        
        */
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}