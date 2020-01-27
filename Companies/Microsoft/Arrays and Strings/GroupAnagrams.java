/*
Group Anagrams
https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/200/
https://leetcode.com/problems/group-anagrams/

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