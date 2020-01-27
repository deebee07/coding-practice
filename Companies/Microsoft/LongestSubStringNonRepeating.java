/*
Use a hashMap to keep track of the latest index of each letter
Keeping the left pointer at rest, move the right pointer by 1 letter at a time.
When a repeating character is encountered, update the maxLength and move the left pointer to max{left pointer, old last occurence of this character as available in the map}. We do a max because we don't want to take the left pointer backwards at any time (e.g. in "abba"), it will only move forward or stay still.
return max {right-left, maxLength}. Doing this outside the loop is essential as it handles strings with all unique chars.
T/S: O(n)/O(n)
https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
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

public int lengthOfLongestSubstring(String s) {
	if (s.length() < 2)
		return s.length();
	Map<Character, Integer> map = new HashMap<>();
	int left = 0;
	int maxLength = 0;
	int right;
	for (right = 0; right < s.length(); right++) {
		char ch = s.charAt(right);
		if (map.containsKey(ch)) {
			maxLength = Math.max(maxLength, right - left);
			left = Math.max(left, map.get(ch) + 1);
		}
		map.put(ch, right);
	}
	return Math.max(right - left, maxLength);
}



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