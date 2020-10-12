
/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.
*/
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length();i++) {
            if(frequencyMap.containsKey(s.charAt(i))){
                frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i))+1);
            }else {
                frequencyMap.put(s.charAt(i), 1);
            }
        }
        
        for(int i=0; i<s.length();i++) {
            if(frequencyMap.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}