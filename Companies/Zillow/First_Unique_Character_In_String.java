/*
https://leetcode.com/problems/first-unique-character-in-a-string/
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