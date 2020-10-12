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