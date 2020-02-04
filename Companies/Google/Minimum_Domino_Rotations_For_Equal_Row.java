/*
https://leetcode.com/problems/minimum-domino-rotations-for-equal-row
Greedy Solution
    Return min number of rotations 
        if one could make all elements in A or B equal to x.
        Else return -1
        
3 possible situations:
    Can make all elements of A row or B row to be the same and equal to A[i] value.
        IF One picks up the 0th element, it's possible to make all elements of A row to be equal to 2.
    Can make all elements of A row or B row to be the same and equal to B[i] value.
        IF One picks up the 1th element, it's possible to make all elements of B row to be equal to 2.
    IMPOSSIBLE to make all elements of A row or B row to have the same A[i] or B[i] value.  
*/

class Solution {

    public int check(int x, int[] A, int[] B, int n) {
      // how many rotations should be done
      // to have all elements in A equal to x
      // and to have all elements in B equal to x
      int rotations_a = 0, rotations_b = 0;
      for (int i = 0; i < n; i++) {
        // rotations coudn't be done
        if (A[i] != x && B[i] != x) return -1;
        // A[i] != x and B[i] == x
        else if (A[i] != x) rotations_a++;
        // A[i] == x and B[i] != x    
        else if (B[i] != x) rotations_b++;
      }
      // min number of rotations to have all
      // elements equal to x in A or B
      return Math.min(rotations_a, rotations_b);
    }
  
    public int minDominoRotations(int[] A, int[] B) {
      int n = A.length;
      int rotations = check(A[0], B, A, n);
      // If one could make all elements in A or B equal to A[0]
      if (rotations != -1 || A[0] == B[0]) return rotations;
      // If one could make all elements in A or B equal to B[0]
      else return check(B[0], B, A, n);
    }
  }