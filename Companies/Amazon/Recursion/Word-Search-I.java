/*

https://leetcode.com/problems/word-search/solution/
Robot room cleaner
*/

  class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board == null)
            return false;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] == word.charAt(0) && dfsHelper(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    public boolean dfsHelper(char [][] board, int i, int j, int count, String word){
        if (count == word.length())
            return true;
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(count))
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean finalResult = dfsHelper(board, i+1, j, count+1, word) ||
                        dfsHelper(board, i-1, j, count+1, word) ||
                        dfsHelper(board, i, j+1, count+1, word) ||
                        dfsHelper(board, i, j-1, count+1, word);
        board[i][j] = temp;
        return finalResult;
    }
}


  