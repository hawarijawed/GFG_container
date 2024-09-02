/*
Given a square grid of size N, each cell of which contains an integer cost that represents a cost to traverse through that cell, we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).  
*/
class Solution
{
    class Tuple{
        int row;
        int col;
        int weight;
        
        Tuple(int a,int b,int c){
            this.row=a;
            this.col=b;
            this.weight=c;
        }
    }
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int res[][]=new int[n][n];
        
        for(int num[]:res)Arrays.fill(num,Integer.MAX_VALUE);
        res[0][0]=grid[0][0];
        int direction[][]={{0,1},{0,-1},{-1,0},{1,0}};
        
        PriorityQueue<Tuple>pq=new PriorityQueue<>((Tuple a,Tuple b)->Integer.compare(a.weight,b.weight));
        pq.add(new Tuple(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Tuple tuple=pq.poll();
            int row=tuple.row;
            int col=tuple.col;
            int weight=tuple.weight;
            
            for(int dir[]:direction){
                int row_=row+dir[0];
                int col_=col+dir[1];
                if(row_>=0&&col_>=0&&row_<n&&col_<n&&(res[row_][col_]>weight+grid[row_][col_])){
                    res[row_][col_]=weight+grid[row_][col_];
                    pq.add(new Tuple(row_,col_,res[row_][col_]));
                }
            }
        }
        return res[n-1][n-1];
    }
}
