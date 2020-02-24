//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/334252/JAVA-or-HashMap-or-Sliding-Window
// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0)  {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 1;
        int j = 0;
        int i =0;
        while(i < s.length()) 
        {
            if(map.size() <= k){
                map.put(s.charAt(i), i++);
            }
            if(map.size() > k) {
                int min = s.length() -1;
                for(int x : map.values()) {
                    min = Math.min(min,x);
                }
                map.remove(s.charAt(min));
                j = min + 1;
            }
            max = Math.max(max, i-j);
        }
        return max;
    }
}


import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0 || str.length() < k)
      throw new IllegalArgumentException();

    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    // in the following loop we'll try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
      // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
      while (charFrequencyMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }
}
