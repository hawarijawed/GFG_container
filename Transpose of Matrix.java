/*
You are given a square matrix of size n x n. Your task is to find the transpose of the given matrix.
The transpose of a matrix is obtained by converting all the rows to columns and all the columns to rows.
*/
class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        int n = mat.length;
        for(int i=0; i<n; i++){
            
            for(int j=i; j<n; j++){
                int val1 = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = val1;
            }
            
        }
        for(int i=0; i<n; i++){
            ArrayList<Integer> lst = new ArrayList<>();
            for(int j=0; j<n; j++){
                lst.add(mat[i][j]);
            }
            
            res.add(lst);
            
        }
        
        return res;
        
    }
}
