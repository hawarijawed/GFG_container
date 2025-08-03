/*
You are given a 2D integer matrix mat[][] of size n × m and a list of q operations opr[][]. Each operation is represented as an array [v, r1, c1, r2, c2], where:

v is the value to be added
(r1, c1) is the top-left cell of a submatrix
(r2, c2) is the bottom-right cell of the submatrix (inclusive)
For each of the q operations, add v to every element in the submatrix from (r1, c1) to (r2, c2). Return the final matrix after applying all operations.
*/

class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int [] op: opr){
            int v = op[0];
            int r1 = op[1];
            int c1 = op[2];
            int r2 = op[3];
            int c2 = op[4];
            for(int i=r1; i<=r2; i++){
                for(int j=c1; j<=c2; j++){
                    mat[i][j] += v;
                }
            }
        }
        
        int row = mat.length;
        int col = mat[0].length;
        for(int i=0; i<row; i++){
            ArrayList<Integer> lst = new ArrayList<>();
            for(int j=0; j<col; j++){
                lst.add(mat[i][j]);
            }
            res.add(lst);
        }
        
        return res;
    }
}
