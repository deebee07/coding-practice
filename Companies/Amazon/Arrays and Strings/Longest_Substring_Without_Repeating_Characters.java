/*
To tell if a character exists or not, we could define a mapping of the characters to its index. Then we can skip the characters immediately when we found a repeated character.

The reason is that if s[j] have a duplicate in the range [i, j)[i,j) with index j'. we don't need to increase i little by little. We can skip all the elements in the range [i, j'] and let i be j'+1 
′
 ] and let ii to be j' + 1j 
′
 +1 directly.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
         if (s.length()==0) return 0;
         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
         int max=0;
         int windowStart = 0;
 
         for (int windowEnd=0; windowEnd<s.length(); windowEnd++){
             Character charAtWinEnd = s.charAt(windowEnd);
 
             if (map.containsKey(charAtWinEnd)){ // This isnt allowed a repeating character
                 windowStart = Math.max(windowStart, map.get(charAtWinEnd)+1);
             }
             map.put(s.charAt(windowEnd),windowEnd); // map has char and its index
             max = Math.max(max, windowEnd-windowStart+1); // max would be curMax or i - j +1
         }
         return max;
     }
 }