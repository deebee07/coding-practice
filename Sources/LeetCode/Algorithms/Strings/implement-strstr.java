/*
https://leetcode.com/problems/implement-strstr/
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        if (haystack.contains(needle)) {
            index = haystack.indexOf(needle);
        }
        return index;
    }
}



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