/*
https://leetcode.com/problems/search-a-2d-matrix/
O(logMN)
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

One could notice that the input matrix m x n could be considered as a sorted array of length m x n.
The algorithm is a standard binary search :

    Initialise left and right indexes left = 0 and right = m x n - 1.

    While left < right :

        Pick up the index in the middle of the virtual array as a pivot index : pivot_idx = (left + right) / 2.

        The index corresponds to row = pivot_idx // n and col = pivot_idx % n in the initial matrix, and hence one could get the pivot_element. 
        This element splits the virtual array in two parts.

Compare pivot_element and target to identify in which part one has to look for target.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length;
      if (m == 0) return false;
      int n = matrix[0].length;
  
      // binary search
      int left = 0, right = m * n - 1;
      int pivotIdx, pivotElement;
      while (left <= right) {
        pivotIdx = (left + right) / 2;
        pivotElement = matrix[pivotIdx / n][pivotIdx % n];
        if (target == pivotElement) {
            return true;
        }
        else if (target < pivotElement){
            right = pivotIdx - 1;
        } else {
            left = pivotIdx + 1;
        }
  
        }
          return false;
      }
  
    }
