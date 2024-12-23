/*
Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].
*/
class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean search(int mat[][], int row, int col, int x){
        int st = 0, en = col-1;
        while(st <= en){
            int mid = st + (en-st)/2;
            if(mat[row][mid] == x) return true;
            else if(mat[row][mid] > x){
                en = mid -1;
            }
            else{
                st = mid+1;
            }
        }
        return false;
    }
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        
        for(int i=0; i<row; i++){
            if(mat[i][0] <= x && x <= mat[i][col - 1]){
                if(search(mat, i, col, x)) return true;
            }
        }
        
        return false;
    }
}
