/*
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
*/
class Solution {
     public int countIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L'){
                    dfs(grid,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
        
    }
    public static void dfs(char[][] grid,int i,int j,int n,int m){
         
        grid[i][j]='K';
        for(int r=-1;r<=1;r++){
            for(int c=-1;c<=1;c++){
                int nr=i+r;
                int nc=j+c;
                if(nr>=0 && nr<n && nc<m && nc>=0 && grid[nr][nc]=='L'){
                   dfs(grid,nr,nc,n,m);
                }
            }
        }
        
    }
}
