/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Complexity Analysis

Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.

BFS: https://leetcode.com/problems/number-of-islands/solution/

*/
class Solution {
    
    
    public void makeZeroByDfs(char[][] grid, int currentRow, int currentColumn) {
        int numRows = grid.length;
        int numColumns = grid[0].length;
        
        if (currentRow<0 || currentColumn<0 || currentRow>=numRows ||currentColumn>=numColumns || grid[currentRow][currentColumn]=='0') return;
        
        grid[currentRow][currentColumn] = '0';
        makeZeroByDfs(grid, currentRow + 1, currentColumn);
        makeZeroByDfs(grid, currentRow, currentColumn + 1);
        makeZeroByDfs(grid, currentRow-1, currentColumn);
        makeZeroByDfs(grid, currentRow, currentColumn-1);
        
        
    }
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0) return 0;
        
        int numRows = grid.length;
        int numColumns = grid[0].length;
        int numIslands = 0;
        for(int row=0; row<numRows; row++) {
            for(int column=0; column<numColumns;column++){
                if(grid[row][column]=='1') {
                    numIslands++;
                    makeZeroByDfs(grid, row, column);
                }
            }
        }
        
        return numIslands;
        
    }
}



/*
BFS:
Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

Space complexity : O(min(M, N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N).

*/



class Solution {
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
        return 0;
      }
  
      int nr = grid.length;
      int nc = grid[0].length;
      int num_islands = 0;
  
      for (int r = 0; r < nr; ++r) {
        for (int c = 0; c < nc; ++c) {
          if (grid[r][c] == '1') {
            ++num_islands;
            grid[r][c] = '0'; // mark as visited
            Queue<Integer> neighbors = new LinkedList<>();
            neighbors.add(r * nc + c);
            while (!neighbors.isEmpty()) {
              int id = neighbors.remove();
              int row = id / nc;
              int col = id % nc;
              if (row - 1 >= 0 && grid[row-1][col] == '1') {
                neighbors.add((row-1) * nc + col);
                grid[row-1][col] = '0';
              }
              if (row + 1 < nr && grid[row+1][col] == '1') {
                neighbors.add((row+1) * nc + col);
                grid[row+1][col] = '0';
              }
              if (col - 1 >= 0 && grid[row][col-1] == '1') {
                neighbors.add(row * nc + col-1);
                grid[row][col-1] = '0';
              }
              if (col + 1 < nc && grid[row][col+1] == '1') {
                neighbors.add(row * nc + col+1);
                grid[row][col+1] = '0';
              }
            }
          }
        }
      }
  
      return num_islands;
    }
  }