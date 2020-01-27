/*
Rotate Image
https://leetcode.com/problems/rotate-image/
https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/202/

Transpose MATRIX: https://leetcode.com/problems/transpose-matrix/solution/

https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
http://javabypatel.blogspot.com/2016/11/rotate-matrix-by-90-degrees-inplace.html

1  2  3             
4  5  6
7  8  9
after transpose, it will be swap(matrix[i][j], matrix[j][i])

1  4  7
2  5  8
3  6  9
Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

7  4  1
8  5  2
9  6  3
*/


/*
Approach 1 : Transpose and then reverse

Obvious idea would be to 
transpose the matrix first and then reverse each row. This simple approach already demonstrates the best possible time complexity \mathcal{O}(N^2)O(N 
2
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

