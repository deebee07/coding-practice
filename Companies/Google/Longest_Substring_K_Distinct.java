/*
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        Map<Character, Integer> charMap = new HashMap<>();
        
        char [] arr  = s.toCharArray();
        
        int i = 0, j = 0, res = 0;
       
        while(i<arr.length) {
            if(charMap.size() > k) {
                int freq = charMap.get(arr[j]);
                if(freq == 1) {
                    charMap.remove(arr[j]);
                } else {
                    charMap.put(arr[j], freq - 1);
                }
              
                j++;
            } else {
                res = Math.max(res, i-j);
                charMap.put(arr[i], charMap.getOrDefault(arr[i],0)+1);
                
                i++;  
                
            }
            
        }
        
        if(charMap.size()<=k) res = Math.max(res, i - j);
        
        return res;
    }
 }