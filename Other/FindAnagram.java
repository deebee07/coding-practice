// https://leetcode.com/problems/find-all-anagrams-in-a-string/solution/
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int winStart = 0;
        int windowLength = 0;
        List<Integer> output = new ArrayList<Integer>();
        if (p.length()>s.length()) return output;
        
        for (int windowEnd=0; windowEnd<s.length(); windowEnd++) {
            windowLength = windowEnd - winStart + 1;
            
            if (windowLength == p.length()) {
                if (isAnagram(p, s.substring(winStart, windowEnd+1))){
                    output.add(winStart);
                }
                winStart++;
            }
        }
        return output;
    }
    
    
    public boolean isAnagram(String str1, String str2) {
        char[] char1_Arr = str1.toCharArray();
        char[] char2_Arr = str2.toCharArray();
        Arrays.sort(char1_Arr);
        Arrays.sort(char2_Arr);
        String sorted_char1 = new String(char1_Arr);
        String sorted_char2 = new String(char2_Arr);
        
        return sorted_char1.equals(sorted_char2) ? true : false;
        
    }
}


class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int ns = s.length(), np = p.length();
    if (ns < np) return new ArrayList();

    Map<Character, Integer> pCount = new HashMap();
    Map<Character, Integer> sCount = new HashMap();
    // build reference hashmap using string p
    for (char ch : p.toCharArray()) {
      if (pCount.containsKey(ch)) {
        pCount.put(ch, pCount.get(ch) + 1);
      }
      else {
        pCount.put(ch, 1);
      }
    }

    List<Integer> output = new ArrayList();
    // sliding window on the string s
    for (int i = 0; i < ns; ++i) {
      // add one more letter 
      // on the right side of the window
      char ch = s.charAt(i);
      if (sCount.containsKey(ch)) {
        sCount.put(ch, sCount.get(ch) + 1);
      }
      else {
        sCount.put(ch, 1);
      }
      // remove one letter 
      // from the left side of the window
      if (i >= np) {
        ch = s.charAt(i - np);
        if (sCount.get(ch) == 1) {
          sCount.remove(ch);
        }
        else {
          sCount.put(ch, sCount.get(ch) - 1);
        }
      }
      // compare hashmap in the sliding window
      // with the reference hashmap
      if (pCount.equals(sCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }
}