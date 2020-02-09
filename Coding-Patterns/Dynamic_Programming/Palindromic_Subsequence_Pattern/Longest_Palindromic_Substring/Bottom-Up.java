class LPS {

    public int findLPSLength(String st) {
      // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
      // palindrome
      boolean[][] dp = new boolean[st.length()][st.length()];
  
      // every string with one character is a palindrome
      for (int i = 0; i < st.length(); i++)
        dp[i][i] = true;
  
      int maxLength = 1;
      for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
        for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
          if (st.charAt(startIndex) == st.charAt(endIndex)) {
            // if it's a two character string or if the remaining string is a palindrome too
            if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
              dp[startIndex][endIndex] = true;
              maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            }
          }
        }
      }
  
      return maxLength;
    }
  
    public static void main(String[] args) {
      LPS lps = new LPS();
      System.out.println(lps.findLPSLength("abdbca"));
      System.out.println(lps.findLPSLength("cdpdd"));
      System.out.println(lps.findLPSLength("pqr"));
    }
  }