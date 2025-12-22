/*
You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

Note:

The array follows 0-based indexing.
The number of rows and columns in the array are denoted by n and m respectively.
*/
// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int m = arr.length;
        int n = arr[0].length;
        int res = -1;
        int maxOne = 0;
        
        for(int j=0; j<m; j++){
            int[] mat = arr[j];
            int currOne = 0;
            for(int i = 0; i<n; i++){
                if(i==0 && mat[n - 1] == 0) break;
                if(mat[i] == 1){
                    currOne = n - i + 1;
                    break;
                }
            }
            if(currOne > maxOne){
                maxOne = currOne;
                res = j;
            }
            
        }
        return res;
    }
}
