/*
https://leetcode.com/problems/set-matrix-zeroes/solution/

*/

/*Use the first column and the first row as marker:

first scan through the whole matrix, and if one row i has zero, label matrix[i][0] = 0, if column j has zero, then label matrix[0][j] = 0.
if we find the first row has zero, then mark a boolean row = true, if the first column has zeros, mark a boolean col = true;

By the markers on the first row and first col, set the other columns and rows to zeros. (first row and first column already contain zeros)

According to booleans row and col, decide whether to set first row and column to zeros.
*/
public class Solution {
     
    public void setZeroes(int[][] matrix) {
   
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int m = matrix.length, n = matrix[0].length;
   
        boolean row = false, col = false;
   
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                }
            }
        
        //make row elements 0 we learnt needs to be made 0
        for (int i = 1; i < m; i++){
            if (matrix[i][0] == 0){
                for (int j = 1; j < n;j++)
                    matrix[i][j] = 0;
            }
        }
       //make column elements 0 we learnt needs to be made 0
        for (int j = 1; j < n; j++){
            if (matrix[0][j] == 0){
                for (int i = 1; i < m; i++)
                    matrix[i][j] = 0;
            }
        }
        
        //make first row 0
        if (row){
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
        if (col){
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
   }