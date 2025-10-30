/*
You are given a grid[][] of size n*m, where every element is either 'O' or 'X'. You have to replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.
*/
class Solution {
    public void fill(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++){
            if(grid[i][0] == 'O') dfs(grid, i, 0);
            if(grid[i][n-1] == 'O') dfs(grid, i, n-1);
        }
        
        for(int j=0; j<n; j++){
            if(grid[0][j] == 'O') dfs(grid, 0, j);
            if(grid[m-1][j] == 'O') dfs(grid, m-1, j);
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
                if(grid[i][j] == '#'){
                    grid[i][j] = 'O';
                }
            }
        }
    }
    
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != 'O'){
            return;
        }
        
        grid[i][j] = '#';
        dfs(grid,i-1, j); //top
        dfs(grid,i+1, j); //bottom
        dfs(grid,i, j-1); //left
        dfs(grid,i, j+1); // rigt
    }
}
