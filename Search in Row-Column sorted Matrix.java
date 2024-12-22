/*
Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.
*/
//--------------------- Approach 01 ---------------------//
class Solution {
    public static boolean helper(int mat[][], int r, int c, int x){
        for(int i=0; i<c; i++){
            if(mat[r][i] == x)
            {
                return true;
            }
        }
        return false;
    }
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int row = mat.length;
        int col = mat[0].length;
        int ind = 0;
        for(int i=0; i<row; i++){
            if(mat[i][col-1] >= x && mat[i][0] <= x){
                ind = i;
                if(helper(mat, i, col,x)){
                    return true;
                }
            }
        }
        for(int i=0; i<col; i++){
            if(mat[ind][i] == x){
                return true;
            }
        }
        return false;
    }
}

//-------------------------------- Approach 02 -------------------------//
class Solution {
    
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int row = mat.length;
        int col = mat[0].length;
        int i = 0, j = col -1;
        while(i<row && j>=0){
            if(mat[i][j] == x){
                return true;
            }
            else if(mat[i][j] > x){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
