/*
In the stock market, a person buys a stock and sells it on some future date. You are given an array prices[] representing stock prices on different days and a positive integer k, find out the maximum profit a person can make in at-most k transactions.

A transaction consists of buying and subsequently selling a stock and new transaction can start only when the previous transaction has been completed.
*/
class Solution {
    static int help(int[] prices , int k ,int i , int b , int[][][] dp){
        if(i==prices.length || k==0){
            return 0;
        }
        
        if(dp[i][k][b]!=-1){
            return dp[i][k][b];
        }
        int ans =help(prices,k,i+1,b,dp);
        if(b==1){
            ans = Math.max(ans , help(prices,k,i+1,0,dp)-prices[i] );
        }
        else{
            ans = Math.max(ans , help(prices,k-1,i+1,1,dp) + prices[i]);
        }
        
        return dp[i][k][b] = ans;
    }
    static int maxProfit(int prices[], int k) {
        // code here
        int[][][] dp = new int[prices.length][k+1][2];
        
        for(int i=0; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return help(prices,k,0,1,dp);
    }
}
