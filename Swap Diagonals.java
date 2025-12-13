/*
Given a square matrix mat[][], the task is to swap the elements of the major and minor diagonals.



Major Diagonal: Elements that lie from the top-left corner to the bottom-right corner of the matrix (i.e., where row index equals column index).
Minor Diagonal: Elements that lie from the top-right corner to the bottom-left corner (i.e., where the sum of row and column indices equals n - 1).
*/
class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
        int n = mat.length;
        for(int i=0; i<n; i++){
           int val1 = mat[i][i];
           mat[i][i] = mat[i][n-1-i];
           mat[i][n-1-i] = val1;
        }
    }
}
/*
0 1 2
3 4 5
6 7 8

00 -> 02
11 -> 11
20 -> 22


0  1  2  3
4  5  6  7
8  9  10 11
12 13 14 15


00 <-> 03
11 <-> 12
22 <-> 21
33 <-> 30

ij <-> i[n-1-j]
*/
