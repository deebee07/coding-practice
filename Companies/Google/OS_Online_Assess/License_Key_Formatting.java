/*
https://leetcode.com/explore/interview/card/google/67/sql-2/472/
https://leetcode.com/problems/license-key-formatting/submissions/
*/

class Solution {
    public String licenseKeyFormatting(String s, int k) {
          StringBuilder sb = new StringBuilder();
          for (int i = s.length() - 1; i >= 0; i--)
              if (s.charAt(i) != '-')
                  sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
          return sb.reverse().toString().toUpperCase();
      } 
  }