/*
Solution with XOR #
    Returns 0 if we do XOR of same numbers
    Returns number if we do XOR with 0

    So we can XOR all the numbers in the input; duplicate numbers will zero out each other and we will be left with the single number.
*/

class SingleNumber {
    public static int findSingleNumber(int[] arr) {
      int num = 0; //XOR
      for (int i=0; i < arr.length; i++) {
        num = num ^ arr[i];
      }
      return num;
    }
  
    public static void main( String args[] ) {
      System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
  }