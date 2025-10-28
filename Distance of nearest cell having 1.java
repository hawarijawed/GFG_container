/*
Given a binary grid[][], where each cell contains either 0 or 1, find the distance of the nearest 1 for every cell in the grid.
The distance between two cells (i1, j1)  and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|. 
You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j] to the nearest cell having value 1.

Note: It is guaranteed that there is at least one cell with value 1 in the grid.
*/
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j});
                    mat[i][j] = 0;
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        
        // Step 2: Define 4 possible directions (up, down, left, right)
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 3: BFS traversal
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int i = cell[0], j = cell[1];

            // Explore 4 directions
            for (int[] d : dirs) {
                int newRow = i + d[0];
                int newCol = j + d[1];

                // Check bounds and unvisited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] = mat[i][j] + 1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        
        for(int i=0; i<m; i++){
            ArrayList<Integer> lst = new ArrayList<>();
            for(int j=0; j<n; j++){
                lst.add(mat[i][j]);
            }
            res.add(new ArrayList<>(lst));
        }
        
        return res;
    }
}
