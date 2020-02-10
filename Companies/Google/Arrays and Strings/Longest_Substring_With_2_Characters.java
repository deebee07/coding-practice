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


//K=2

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      int n = s.length();
      if (n*k == 0) return 0;
  
      // sliding window left and right pointers
      int left = 0;
      int right = 0;
      // hashmap character -> its rightmost position 
      // in the sliding window
      HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
  
      int max_len = 1;
  
      while (right < n) {
        // add new character and move right pointer
        hashmap.put(s.charAt(right), right++);
  
        // slidewindow contains 3 characters
        if (hashmap.size() == k + 1) {
          // delete the leftmost character
          int del_idx = Collections.min(hashmap.values());
          hashmap.remove(s.charAt(del_idx));
          // move left pointer of the slidewindow
          left = del_idx + 1;
        }
  
        max_len = Math.max(max_len, right - left);
      }
      return max_len;
    }
  }

  class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
      int n = s.length();
      if (n < 3) return n;
  
      // sliding window left and right pointers
      int left = 0;
      int right = 0;
      // hashmap character -> its rightmost position 
      // in the sliding window
      HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
  
      int max_len = 2;
  
      while (right < n) {
        // slidewindow contains less than 3 characters
        if (hashmap.size() < 3)
          hashmap.put(s.charAt(right), right++);
  
        // slidewindow contains 3 characters
        if (hashmap.size() == 3) {
          // delete the leftmost character
          int del_idx = Collections.min(hashmap.values());
          hashmap.remove(s.charAt(del_idx));
          // move left pointer of the slidewindow
          left = del_idx + 1;
        }
  
        max_len = Math.max(max_len, right - left);
      }
      return max_len;
    }
  }