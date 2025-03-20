/*
In daily share trading, a trader buys shares and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.

You are given an array prices[] representing stock prices throughout the day. Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).
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
    public static int maxProfit(int[] prices) {
        int k = 2;
        int[][][] dp = new int[prices.length][k+1][2];
        
        for(int i=0; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return help(prices,k,0,1,dp);
    }
}
