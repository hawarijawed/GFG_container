/*
Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.
Note: Answer can be very large, so, output answer modulo 109+7.
*/
class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    int MOD = 1000000007;
        int[] dp = new int[sum + 1];

        // Base case: one way to make sum 0
        dp[0] = 1;

        // Fill the dp array
        for (int num : arr) {
            for (int j = sum; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MOD;
            }
        }

        return dp[sum];
	} 
}
