class Solution {
    public String longestPalindrome(String s) {

        char[] charArray = s.toCharArray();
        String longestPalindrome = ""; // one length is always palindrome
        int maxLength = 0;
        
        for(int i=0;i<s.length();i++) {
            if (isPalindromic(charArray, i-maxLength-1, i)) { //either current maxLength-1 to i value
                longestPalindrome = s.substring(i-maxLength-1, i+1);
                maxLength = maxLength+2; //increment by 2
            } else if (isPalindromic(charArray, i-maxLength, i)) { //either current maxLength to i value 
                longestPalindrome = s.substring(i-maxLength, i+1);
                maxLength = maxLength+1; //increment by 1 
            }
        }
        return longestPalindrome;
        
    }
    
    public boolean isPalindromic(char[] charArray, int left, int right) {
        
        if(left<0 || right>charArray.length-1) {
            return false;
        }
        
        while (left<right){
            if (charArray[left]==charArray[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}

class LPS {

    public int findLPSLength(String st) {
      Integer[][] dp = new Integer[st.length()][st.length()];
      return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    }
  
    private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
      if (startIndex > endIndex)
        return 0;
  
      // every string with one character is a palindrome
      if (startIndex == endIndex)
        return 1;
  
      if (dp[startIndex][endIndex] == null) {
        // case 1: elements at the beginning and the end are the same
        if (st.charAt(startIndex) == st.charAt(endIndex)) {                     
          int remainingLength = endIndex - startIndex - 1;
          // check if the remaining string is also a palindrome
          if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
            dp[startIndex][endIndex] = remainingLength + 2;
            return dp[startIndex][endIndex];
          }
        }
  
        // case 2: skip one character either from the beginning or the end
        int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
        int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
        dp[startIndex][endIndex] = Math.max(c1, c2);
      }
  
      return dp[startIndex][endIndex];
    }
  
    public static void main(String[] args) {
      LPS lps = new LPS();
      System.out.println(lps.findLPSLength("abdbca"));
      System.out.println(lps.findLPSLength("cddpd"));
      System.out.println(lps.findLPSLength("pqr"));
    }
  }