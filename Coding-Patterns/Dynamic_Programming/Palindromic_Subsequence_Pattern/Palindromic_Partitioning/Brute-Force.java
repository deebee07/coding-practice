class MPP {

    public int findMPPCuts(String st) {
      return this.findMPPCutsRecursive(st, 0, st.length()-1);
    }
  
    private int findMPPCutsRecursive(String st, int startIndex, int endIndex) {
      // we don't need to cut the string if it is a palindrome
      if(startIndex >= endIndex || isPalindrome(st, startIndex, endIndex))
        return 0;
  
      // at max, we need to cut the string into its 'length-1' pieces
      int minimumCuts = endIndex-startIndex;
      for (int i=startIndex; i <= endIndex; i++) {
        if(isPalindrome(st, startIndex, i)){
          // we can cut here as we have a palindrome from 'startIndex' to 'i'
          minimumCuts = Math.min(minimumCuts, 1 + findMPPCutsRecursive(st, i+1, endIndex));
        }
      }
      return minimumCuts;
    }
  
    private boolean isPalindrome(String st, int x, int y) {
      while(x < y) {
        if(st.charAt(x++) != st.charAt(y--))
          return false;
      }
      return true;
    }
  
    public static void main(String[] args) {
      MPP mpp = new MPP();
      System.out.println(mpp.findMPPCuts("abdbca"));
      System.out.println(mpp.findMPPCuts("cdpdd"));
      System.out.println(mpp.findMPPCuts("pqr"));
      System.out.println(mpp.findMPPCuts("pp"));
     }
  }
  