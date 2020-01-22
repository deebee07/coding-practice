/*
https://leetcode.com/problems/excel-sheet-column-number/
*/

class Solution {
    public int titleToNumber(String s) {
        if (s==null || s.length() ==0) return 0;
        
        int evaluation = 0;
        int digit = 0;
        for(int i=s.length()-1; i>=0;i--) {
            
            int c = s.charAt(i)-64;
            evaluation += c*Math.pow(26, digit);
            digit++;
        }
        return evaluation;
        
    }
}