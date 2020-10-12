
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Time complexity : O(N2)
 ).
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
         // transpose matrix
        for (int row = 0; row < n; row++) {
          for (int column = row; column < n; column++) {
            int tmp = matrix[column][row];
            matrix[column][row] = matrix[row][column];
            matrix[row][column] = tmp;
          }
        }
        
        // reverse each row
        for (int row = 0; row < n; row++) {
          for (int column = 0; column < n / 2; column++) {
            int tmp = matrix[row][column];
            matrix[row][column] = matrix[row][n - column - 1];
            matrix[row][n - column - 1] = tmp;
          }
        }
        
    }
}
