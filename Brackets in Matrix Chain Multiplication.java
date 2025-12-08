/*
Given an array arr[] of length n used to denote the dimensions of a series of matrices such that the dimension of i'th matrix is arr[i] * arr[i+1]. There are a total of n-1 matrices. Find the most efficient way to multiply these matrices together. 
Your task is to return the string which is formed of A - Z (only Uppercase) denoting matrices & Brackets( "(" ")" ) denoting multiplication symbols. For example, if n = 11, the matrixes can be denoted as A - K as n <= 26 & multiplication of A and B is denoted as (AB).

NOTE:

Each multiplication is denoted by putting open & closed brackets to the matrices multiplied & also, please note that the order of matrix multiplication matters, as matrix multiplication is non-commutative A*B != B*A
As there can be multiple possible answers, the console would print "true" for the correct string and "false" for the incorrect string. You need to only return a string that performs a minimum number of multiplications.
*/
class Solution {
    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        
        int[][] dp = new int[n][n];
        int[][] split = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                               + arr[i - 1] * arr[k] * arr[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }

        return build(1, n - 1, split, new char[]{'A'});
    }

    public String build(int i, int j, int[][] split, char[] name) {
        if (i == j) {
            return String.valueOf(name[0]++);
        }
        int k = split[i][j];
        return "(" + build(i, k, split, name)
                   + build(k + 1, j, split, name) + ")";
    }
}
