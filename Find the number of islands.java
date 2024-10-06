/*
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.
Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
*/
class Solution {
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0'; // Mark as visited

            // Direction vectors for 8 directions   
            int[] dirX = {1, -1, 0, 0, 1, 1, -1, -1};
            int[] dirY = {0, 0, 1, -1, 1, -1, 1, -1};

            for (int d = 0; d < 8; d++) {
                dfs(grid, i + dirX[d], j + dirY[d]);
            }
        }
    }

    public int numIslands(char[][] grid) {
        // Code here
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
}
