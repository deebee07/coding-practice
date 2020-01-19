/*
Transpose of a Matrix
Inplace not inplace
*/
class Solution {
    public int[][] transpose(int[][] A) {
        
        int R = A.length;
        int C = A[0].length;
        
        int[][] result = new int[C][R];
        
        for(int r=0; r<R;r++)
            for(int c=0; c<C; c++) {
                result[c][r] = A[r][c];
            }
        return result;
    }
}



/*
INPLACE
Only work for a Square Matrix that is having same number of Rows and Columns.

Transpose of given matrix can be obtained by:
    changing its rows to columns and columns to rows. 
    Iterate through a Matrix:
        swap data of rows and columns.

While iterating make sure, Column start from where Row start.
*/

class Solution {
    public int[][] transpose(int[][] A) {
        
        int R = A.length;
        int C = A[0].length;
        
        for(int r=0; r<R;r++)
            for(int c=0; c<C; c++) {
                int temp = A[r][c];
                A[r][c] = A[c][r];
                A[c][r] = temp;
            }
        return A;
    }
}