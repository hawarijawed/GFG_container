/*
Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.
*/
class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        
        int st = 0, en = row*col-1;
        while(st<=en){
            int mid = st + (en - st)/2;
            int r = mid/col;
            int c = mid%col;
            int val = mat[r][c];
            
            if(val == x) return true;
            else if(val > x) en = mid-1;
            else st = mid+1;
        }
        
        return false;
        
    }
}
