/*
https://leetcode.com/problems/valid-tic-tac-toe-state/submissions/


public boolean validTicTacToe(String[] board) {
    int turns = 0;
    boolean xWin = false;
    boolean yWin = false;
    int[] rows = new int[3];
    int[] columns = new int[3];
    int diagonal = 0;
    int antiDiagonal = 0;

    for (int i =0; i<3; i++) {
        for (int j =0; j<3;j++) {
            if (board[i].charAt(j)=='X') {
                turns++;
                rows[i]++;
                columns[j]++;
                if (i == j) diagonal++;
                if (3 - i - 1 == j) antiDiagonal++;

            } else if (board[i].charAt(j)=='O') {
                turns--;
                rows[i]--;
                columns[j]--;
                if (i == j) diagonal--;
                if (3 - i - 1 == j) antiDiagonal++;
            }
        }
    }
    xWin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 || columns[0] == 3 || columns[1] == 3 || columns[2] == 3 || diagonal ==3 || antidiagonal==3;
    yWin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 || columns[0] == -3 || columns[1] == -3 || columns[2] == -3 || diagonal ==-3 || antidiagonal==-3;
    if (xWin && turns==0)
}
*/

class Solution {
    public boolean validTicTacToe(String[] board) {
        int turns = 0;
        boolean xwin = false; 
        boolean owin = false;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antidiag = 0;
				
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++; rows[i]++; cols[j]++;
                    if (i == j) diag++;
                    if (3- i -1  == j) antidiag++;
                } else if (board[i].charAt(j) == 'O') {
                    turns--; rows[i]--; cols[j]--;
                    if (i == j) diag--;
                    if (i + j == 2) antidiag--;
                }
            }
        }
		
        xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 || 
               cols[0] == 3 || cols[1] == 3 || cols[2] == 3 || 
               diag == 3 || antidiag == 3;
        owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 || 
               cols[0] == -3 || cols[1] == -3 || cols[2] == -3 || 
               diag == -3 || antidiag == -3;
        
        if (xwin && turns == 0 || owin && turns == 1) {
            return false;
        }
        return (turns == 0 || turns == 1) && (!xwin || !owin);
    }
}