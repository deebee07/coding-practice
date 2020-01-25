/*
https://leetcode.com/problems/number-of-segments-in-a-string
*/
class Solution {
    public int countSegments(String s) {

        s = s.trim();
        if (s == null || s.isEmpty() || s.length()==0 ) return 0;
        String[] sArr = s.split(" +");
        return sArr.length;
        
    }
}