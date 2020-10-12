/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.

*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        if strs are null or length is 0 return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        // map keeps key as sorted STRING
        
        iterate over String in strs with String s:
            char[] toChar = s.toCharArray();
            Arrays.sort(toChar);
            String keyForMap = String.valueOf(toChar);
            
            if (map.containsKey(keyForMap)) {
                map.get(keyForMap).add(s);
            } else {
            List<String> listToAdd = new ArrayList<String>();
            listToAdd.add(s);
            map.put(keyForMap, listToAdd.add)
            }
        return new ArrayList<List<String>>(map.values());

        Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.
        */
        
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());

    }
}
