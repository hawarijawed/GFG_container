/*
You are given a 2d list grid[][] of size n x m consisting of values 0 and 1.
A value of 0 means that you can enter that cell and 1 implies that entry to that cell is not allowed.
You start at the upper-left corner of the grid (1, 1) and you have to reach the bottom-right corner (n, m) such that you can only move in the right or down direction from every cell.
Your task is to calculate the total number of ways of reaching the target.

Note: The first (1, 1) and last (n, m) cell of the grid can also be 1.
It is guaranteed that the total number of ways will fit within a 32-bit integer.
*/
class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        int r = grid.length;
        int c = grid[0].length;
        int mat[][] = new int[r][c];
        
        if(grid[0][0] == 1 || grid[r-1][c-1] == 1){
            return 0;
        }
        
        mat[0][0] =1;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    mat[i][j] = 0;
                }
                else{
                    if(i>0){
                        mat[i][j] += mat[i-1][j];
                    }
                    if(j>0){
                        mat[i][j] += mat[i][j-1];
                    }
                }
            }
        }
        return mat[r-1][c-1];
    }
};
