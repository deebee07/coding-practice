/*
https://leetcode.com/problems/longest-common-prefix/solution/
    if strs.length == 0 return ""
    Assume prefix as wholeString at 0 index of strs
    for (int i = 1; i<str.length;i++){
        while(strs[i].indexOf(prefix)!=0){
            prefix = prefix.substring(0, prefix.length()-1);
            if (prefix.isEmpty()) return "";
        }
    }


*/ 
class Solution {
    public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }        
    return prefix;
}
    
}
