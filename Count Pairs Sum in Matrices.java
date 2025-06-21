/*
Given two matrices mat1[][] and mat2[][] of size n x n, where the elements in each matrix are arranged in strictly ascending order. Specifically, each row is sorted from left to right, and the last element of a row is smaller than the first element of the next row.
You're given a target value x, your task is to find and count all pairs {a, b} such that a is from mat1 and b is from mat2 where the sum of a + b is equal to x
*/
class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here 
        HashSet<Integer> set = new HashSet<>();
        for(int[] arr: mat1){
            for(int a: arr){
                set.add(a);
            }
        }
        int count = 0;
        int m = mat2.length;
        int n = mat2[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int target = x - mat2[i][j];
                if(set.contains(target)){
                    count++;
                }
            }
        }
        
        return count;
    }
}
