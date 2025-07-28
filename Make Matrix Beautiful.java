/*
A beautiful matrix is defined as a square matrix in which the sum of elements in every row and every column is equal. Given a square matrix mat[][], your task is to determine the minimum number of operations required to make the matrix beautiful.
In one operation, you are allowed to increment the value of any single cell by 1.
*/

class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int maxRowSum=0;
        int maxColumSum=0;
        int matrixSum=0;
        int n=mat.length;
        for(int i=0;i<n;i++){
            int imaxRowSum=0;
            int imaxColumSum=0;
            for(int j=0;j<n;j++){
                matrixSum+=mat[i][j];
                imaxRowSum+=mat[i][j];
                imaxColumSum+=mat[j][i];
            }
            maxRowSum=Math.max(maxRowSum,imaxRowSum);
            maxColumSum=Math.max(maxColumSum,imaxColumSum);
        }
        int max=Math.max(maxRowSum,maxColumSum);
        return (max*n)-matrixSum;
    }
}
