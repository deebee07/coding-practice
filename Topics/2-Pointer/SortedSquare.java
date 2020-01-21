/*
https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
*/
class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
      int n = arr.length;
      int[] squares = new int[n];
      int highestSquareIdx = n - 1;
      int left = 0, right = arr.length - 1;
      while (left <= right) {
        int leftSquare = arr[left] * arr[left];
        int rightSquare = arr[right] * arr[right];
        if (leftSquare > rightSquare) {
          squares[highestSquareIdx] = leftSquare;
          left++;
          highestSquareIdx--;
        } else {
          squares[highestSquareIdx] = rightSquare;
          right--;
          highestSquareIdx--;
        }
      }
      return squares;
    }
  
    public static void main(String[] args) {
  
      int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
      for (int num : result)
        System.out.print(num + " ");
      System.out.println();
  
      result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
      for (int num : result)
        System.out.print(num + " ");
      System.out.println();
    }
  }
  

  class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length==0) return A;
        
        int left = 0;
        int right = A.length-1;
        int endInd = right;
        int[] squareArr = new int[A.length];
        
        while(left<=right) {
            int leftSq = A[left]*A[left];
            int rightSq = A[right]*A[right];
            if (leftSq>rightSq) {
                squareArr[endInd]=leftSq;
                    left++;
                    endInd--;
            }else {
                squareArr[endInd]=rightSq;
                    right--;
                    endInd--;
            }
        }
        return squareArr;
        
    }
}